package at.ac.tuwien.ase2016.service.impl;

import at.ac.tuwien.ase2016.domain.londonair.advice.AirQualityIndexHealthAdvice;
import at.ac.tuwien.ase2016.domain.londonair.advice.HealthAdvice;
import at.ac.tuwien.ase2016.domain.subscriptions.Subscription;
import at.ac.tuwien.ase2016.repository.AirQualityIndexHealthAdviceRepository;
import at.ac.tuwien.ase2016.service.INotificationService;
import at.ac.tuwien.ase2016.spring.ApplicationProperties;
import org.apache.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;


/**
 * Created by DanielHofer on 12.06.2016.
 */

@Service
public class NotificationService implements INotificationService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    protected ApplicationProperties applicationProperties;

    @Autowired
    private AirQualityIndexHealthAdviceRepository airQualityIndexHealthAdviceRepository;

    private static final org.apache.log4j.Logger logger = LogManager.getLogger(NotificationService.class);

    @Override
    public void sendNotification(Subscription subscription) {

        String advice = "Warning! Air Quality threshold in your area exceeded. Advice: ";

        //get current health advice
        AirQualityIndexHealthAdvice airQualityIndexHealthAdvice = airQualityIndexHealthAdviceRepository.findAll().get(0);

        //get health advice for subscription
        for (HealthAdvice healthAdvice : airQualityIndexHealthAdvice.getAirQualityIndexHealthAdvice().getHealthAdvice()){

            if (Double.valueOf(healthAdvice.getLowerAirQualityIndex()) <= subscription.getThreshold() && Double.valueOf(healthAdvice.getUpperAirQualityIndex()) >= subscription.getThreshold()){
                advice += healthAdvice.getAdvice();
                break;
            }
        }

        //create notification
        if (subscription.isNotifyViaPhone() && subscription.getPhoneNumber() != null) {
            sendSmsNotification(advice, subscription.getPhoneNumber());
        }

        if (subscription.isNotifyViaEmail() && subscription.getMailAddress() != null) {
            sendMailNotification(advice, subscription.getMailAddress());
        }
    }

    public void sendMailNotification(String messageContent, String receiverEmail) {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = null;
        try {
            helper = new MimeMessageHelper(message, true);
            helper.setTo(receiverEmail);
            helper.setSubject("London Air - Notification");
            helper.setText(messageContent);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        mailSender.send(message);
    }

    public void sendSmsNotification(String messageContent, String receiverPhoneNumber) {

        String response;
        try {
            response = restTemplate.getForObject("https://api.websms.com/rest/smsmessaging/simple?access_token={accessToken}&recipientAddressList={recipientAddressList}&messageContent={messageContent}&test={test}"
                    , String.class
                    , applicationProperties.getSmsAccessToken()
                    , receiverPhoneNumber
                    , messageContent
                    , applicationProperties.getSmsSimulation());

            logger.info("sms service response: "+response);

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}
