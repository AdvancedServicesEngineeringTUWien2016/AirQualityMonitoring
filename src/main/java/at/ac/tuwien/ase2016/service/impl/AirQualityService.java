package at.ac.tuwien.ase2016.service.impl;

import at.ac.tuwien.ase2016.domain.AirQualityIndex;
import at.ac.tuwien.ase2016.domain.HourlyAirQualityIndex;
import at.ac.tuwien.ase2016.repository.HourlyAirQualityIndexRepository;
import at.ac.tuwien.ase2016.service.IAirQualityService;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

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
    private HourlyAirQualityIndexRepository hourlyAirQualityIndexRepository;

    private static final Logger logger = LogManager.getLogger(AirQualityService.class);


    @Override
    public HourlyAirQualityIndex updateAirQualityIndex() throws Exception {

        //set property for json processing -> ACCEPT_SINGLE_VALUE_AS_ARRAY
        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper mapper = new ObjectMapper();
        MappingJackson2HttpMessageConverter convertor = new MappingJackson2HttpMessageConverter();
        convertor.setObjectMapper(mapper);
        mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        restTemplate.setMessageConverters(Collections.singletonList(convertor));

        //get current aur quality data
        AirQualityIndex airQualityIndex =
                restTemplate.getForObject("http://api.erg.kcl.ac.uk/AirQuality/Hourly/MonitoringIndex/GroupName=London/Json", AirQualityIndex.class);


        //delete old air index
        hourlyAirQualityIndexRepository.deleteAll();
        //store update air index
        hourlyAirQualityIndexRepository.save(airQualityIndex.getHourlyAirQualityIndex());

        return airQualityIndex.getHourlyAirQualityIndex();

    }

    @Override
    public HourlyAirQualityIndex getCurrentAirQualityIndex() throws Exception {

        List<HourlyAirQualityIndex> hourlyAirQualityIndex = hourlyAirQualityIndexRepository.findAll();

        //return first (there is only one at a time)
        return hourlyAirQualityIndex.get(0);
    }
}

