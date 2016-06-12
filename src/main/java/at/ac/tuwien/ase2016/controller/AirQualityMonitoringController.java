package at.ac.tuwien.ase2016.controller;


import at.ac.tuwien.ase2016.domain.HourlyAirQualityIndex;
import at.ac.tuwien.ase2016.service.IAirQualityService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by DanielHofer on 12.06.2016.
 */


@RestController
public class AirQualityMonitoringController {

    @Autowired
    private IAirQualityService airQualityService;

    private static final Logger logger = LogManager.getLogger(AirQualityMonitoringController.class);


    @RequestMapping(value = "/airQualityIndex", method = RequestMethod.GET)
    @ResponseBody
    public HourlyAirQualityIndex getCurrentAirQualityIndex() throws Exception {

        logger.info("get current index");

        return airQualityService.getCurrentAirQualityIndex();

    }


}
