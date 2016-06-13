package at.ac.tuwien.ase2016.service.impl;

import at.ac.tuwien.ase2016.domain.londonair.*;
import at.ac.tuwien.ase2016.domain.londonair.advice.AirQualityIndexHealthAdvice;
import at.ac.tuwien.ase2016.domain.subscriptions.Subscription;
import at.ac.tuwien.ase2016.domain.subscriptions.User;
import at.ac.tuwien.ase2016.repository.*;
import at.ac.tuwien.ase2016.service.IAirQualityService;
import at.ac.tuwien.ase2016.spring.ApplicationProperties;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



/**
 * Created by DanielHofer on 12.06.2016.
 */

@Service
@Transactional
public class AirQualityService implements IAirQualityService {

    @Autowired
    protected RestTemplate restTemplate;

    @Autowired
    protected NotificationService notificationService;

    @Autowired
    private SiteRepository siteRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AirQualityIndexHealthAdviceRepository airQualityIndexHealthAdviceRepository;

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Autowired
    private HourlyAirQualityIndexRepository hourlyAirQualityIndexRepository;

    @Autowired
    protected ApplicationProperties applicationProperties;

    private static final Logger logger = LogManager.getLogger(AirQualityService.class);

    @Override
    public AirQualityIndexHealthAdvice updateHealthAdvice() throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        AirQualityIndexHealthAdvice airQualityIndexHealthAdvice = null;

        try {
            //simulate api?
            if (applicationProperties.getSchedulerSimulate()){
                //simulation: get current air health advice from file
                airQualityIndexHealthAdvice =
                        mapper.readValue(new File(applicationProperties.getSchedulerSimulateDir()+"health.json"), AirQualityIndexHealthAdvice.class);
            }else{
                    //get current air health advice from api
                airQualityIndexHealthAdvice =
                        restTemplate.getForObject("http://api.erg.kcl.ac.uk/AirQuality/Information/IndexHealthAdvice/Json", AirQualityIndexHealthAdvice.class);
            }
        }catch(Exception e){
            //TODO errror handling
            e.printStackTrace();
        }

        //delete all existing sites
        airQualityIndexHealthAdviceRepository.deleteAll();
        //store updated sites
        airQualityIndexHealthAdviceRepository.save(airQualityIndexHealthAdvice);

        return airQualityIndexHealthAdvice;

    }

    @Override
    public HourlyAirQualityIndex updateAirQualityIndex() throws Exception {

        //set property for json processing -> ACCEPT_SINGLE_VALUE_AS_ARRAY
        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper mapper = new ObjectMapper();
        MappingJackson2HttpMessageConverter convertor = new MappingJackson2HttpMessageConverter();
        convertor.setObjectMapper(mapper);
        mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        restTemplate.setMessageConverters(Collections.singletonList(convertor));

        AirQualityIndex airQualityIndex = null;
        try {

            //simulate api?
            if (applicationProperties.getSchedulerSimulate()){
                //simulation: get current air quality data from file
                airQualityIndex =
                        mapper.readValue(new File(applicationProperties.getSchedulerSimulateDir()+"air.json"), AirQualityIndex.class);
            }else{
                //get current air quality data from api
                airQualityIndex =
                        restTemplate.getForObject("http://api.erg.kcl.ac.uk/AirQuality/Hourly/MonitoringIndex/GroupName=London/Json", AirQualityIndex.class);
            }

        }catch(Exception e){
            //TODO errror handling
            e.printStackTrace();
        }

        List<Site> sites = new ArrayList<>();
        for (LocalAuthority localAuthority : airQualityIndex.getHourlyAirQualityIndex().getLocalAuthority()){
            for (Site site : localAuthority.getSite()){
                //calc position
                site.setAddressLocation();
            }
            sites.addAll(localAuthority.getSite());
        }


        //delete all existing sites
        siteRepository.deleteAll();
        //store updated sites
        siteRepository.save(sites);

        return airQualityIndex.getHourlyAirQualityIndex();

    }

    @Override
    public HourlyAirQualityIndex getCurrentAirQualityIndex() throws Exception {

        List<HourlyAirQualityIndex> hourlyAirQualityIndex = hourlyAirQualityIndexRepository.findAll();

        //return first (there is only one at a time)
        return hourlyAirQualityIndex.get(0);
    }

    @Override
    public void processSubscriptions() throws Exception {

       // List<Site>  sites1 = siteRepository.findAll();

        //Distance distance = new Distance(15, Metrics.KILOMETERS);
        //List<Site>  sites2 = siteRepository.findByAddressLocationNear(new Point(0.177891, 51.563752), distance);


        List<Site> sites;
        double sumSpeciesIndex;
        int speciesCount;
        double averageAirQualityIndex;

        //gett all subscriptions
        List<Subscription> subscriptions = subscriptionRepository.findAll();

        for(Subscription subscription : subscriptions){

            logger.info("--> PROCESS subscription with id "+ subscription.getId());

            sumSpeciesIndex = 0.0;
            speciesCount = 0;

            //find all measuring sites within the radius
            Distance distance = new Distance(subscription.getRadius(), Metrics.KILOMETERS);
            sites = siteRepository.findByAddressLocationNear(new Point(subscription.getLongitude(), subscription.getLatitude()), distance);

            for(Site site : sites){

                logger.info("process site with id "+site.getSiteName());

                //summarize airquality index for all species
                for(Species species : site.getSpecies()){

                    logger.info("process species with id "+species.getSpeciesCode());

                    if(species.getAirQualityIndex() != null){
                        sumSpeciesIndex += Double.valueOf(species.getAirQualityIndex());
                    }

                }
                //summarize number of species
                speciesCount += site.getSpecies().size();
            }

            //calculate average airQualityIndex for subscription
            averageAirQualityIndex = sumSpeciesIndex / speciesCount;

            //threshold exceeded? --> send notification
            if (averageAirQualityIndex >= subscription.getThreshold()){
                notificationService.sendNotification(subscription);
            }

            logger.info("--> SUMMARY for subscription "+subscription.getId()+": averageAirQualityIndex="+averageAirQualityIndex);

        }

    }

    public void createTestData() throws Exception{

        createUserTestData();
        this.updateAirQualityIndex();
        this.updateHealthAdvice();
    }

    public void createUserTestData(){

        userRepository.deleteAll();
        subscriptionRepository.deleteAll();

        List<User> users = new ArrayList<>();
        List<Subscription> subscriptions = new ArrayList<>();

        //USER 1
        User u = new User();
        u.setId("1");
        u.setName("Willi Haben");
        u.setAvatar("svg-2");
        u.setSubscribedUser(false);
        u.setMailAddress("ase2016.tuvienna@gmail.com");

        //subscription 1 for user 1
        Subscription s = new Subscription();
        s.setId("1");
        s.setLatitude(51.563752);
        s.setLongitude(0.177891);
        s.setMailAddress("ase2016.tuvienna@gmail.com");
        s.setNotifyViaEmail(true);
        s.setNotifyViaPhone(false);
        s.setRadius(15);
        s.setThreshold(5d);

        u.addSubscription(s);
        users.add(u);
        subscriptions.add(s);

        //USER 2
        u = new User();
        u.setId("2");
        u.setName("Gertie Ganse");
        u.setAvatar("svg-3");
        u.setSubscribedUser(true);
        u.setMailAddress("ase2016.tuvienna@gmail.com");
        u.setPhoneNumber("0043699189457777");

        //subscription 1 for user 2
        s = new Subscription();
        s.setId("2");
        s.setLatitude(51.529389);
        s.setLongitude(0.132857);
        s.setMailAddress("ase2016.tuvienna@gmail.com");
        s.setNotifyViaEmail(true);
        s.setPhoneNumber("0043699189457777");
        s.setNotifyViaPhone(true);
        s.setRadius(5);
        s.setThreshold(8d);

        subscriptions.add(s);

        u.addSubscription(s);

        //subscription 2 for user 2
        s = new Subscription();
        s.setId("3");
        s.setLatitude(51.4946486813055);
        s.setLongitude(0.137279111232178);
        s.setMailAddress("ase2016.tuvienna@gmail.com");
        s.setNotifyViaEmail(true);
        s.setPhoneNumber("0043699189457777");
        s.setNotifyViaPhone(true);
        s.setRadius(8);
        s.setThreshold(7d);

        subscriptions.add(s);

        u.addSubscription(s);
        users.add(u);

        //USER 3
        u = new User();
        u.setId("3");
        u.setName("Reiner Wahnsinn");
        u.setAvatar("svg-4");
        u.setSubscribedUser(true);
        u.setMailAddress("ase2016.tuvienna@gmail.com");
        u.setPhoneNumber("0043699189457777");

        //subscription 1 for user 2
        s = new Subscription();
        s.setId("4");
        s.setLatitude(51.529389);
        s.setLongitude(0.132857);
        s.setMailAddress("ase2016.tuvienna@gmail.com");
        s.setNotifyViaEmail(true);
        s.setPhoneNumber("0043699189457777");
        s.setNotifyViaPhone(true);
        s.setRadius(5);
        s.setThreshold(8d);

        subscriptions.add(s);

        u.addSubscription(s);

        //subscription 2 for user 2
        s = new Subscription();
        s.setId("5");
        s.setLatitude(51.4946486813055);
        s.setLongitude(0.137279111232178);
        s.setMailAddress("ase2016.tuvienna@gmail.com");
        s.setNotifyViaEmail(true);
        s.setPhoneNumber("0043699189457777");
        s.setNotifyViaPhone(true);
        s.setRadius(10);
        s.setThreshold(5d);

        subscriptions.add(s);

        u.addSubscription(s);
        users.add(u);

        //store to db
        userRepository.save(users);
        subscriptionRepository.save(subscriptions);


    }


}

