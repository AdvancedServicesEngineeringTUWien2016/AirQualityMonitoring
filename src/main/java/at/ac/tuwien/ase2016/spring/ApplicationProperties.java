package at.ac.tuwien.ase2016.spring;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * Created by Daniel Hofer on 12.06.2016
 */


@Configuration
@PropertySource("classpath:application.properties")
public class ApplicationProperties {

    @Value("${notification.sms.simulation}")
    private String SmsSimulation;

    @Value("${notification.sms.accesstoken}")
    private String SmsAccessToken;

    @Value("${scheduler.airIndexUpdate.simulate}")
    private Boolean schedulerSimulate;

    public String getSmsSimulation() {
        return SmsSimulation;
    }

    public String getSmsAccessToken() {
        return SmsAccessToken;
    }

    public Boolean getSchedulerSimulate() {
        return schedulerSimulate;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

}