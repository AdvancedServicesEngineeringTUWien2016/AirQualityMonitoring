package at.ac.tuwien.ase2016.service.impl;

import at.ac.tuwien.ase2016.service.IAirQualityService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by DanielHofer on 12.06.2016.
 */


@Component
public class AirServiceScheduler {

    @Autowired
    private IAirQualityService airQualityService;

    private static final Logger logger = LogManager.getLogger(AirServiceScheduler.class);

    //1 hour
    @Scheduled(fixedRate = 60* 60 * 1000)
    public void reportCurrentTime() {
        logger.info("Update air quality index");

        try {
            airQualityService.updateAirQualityIndex();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
