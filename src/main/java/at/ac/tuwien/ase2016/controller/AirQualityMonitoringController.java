package at.ac.tuwien.ase2016.controller;


import at.ac.tuwien.ase2016.domain.londonair.HourlyAirQualityIndex;
import at.ac.tuwien.ase2016.domain.londonair.advice.AirQualityIndexHealthAdvice;
import at.ac.tuwien.ase2016.domain.subscriptions.Subscription;
import at.ac.tuwien.ase2016.domain.subscriptions.User;
import at.ac.tuwien.ase2016.service.IAirQualityService;
import at.ac.tuwien.ase2016.service.IUserService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by DanielHofer on 12.06.2016.
 */


@RestController
public class AirQualityMonitoringController {

    @Autowired
    private IAirQualityService airQualityService;

    @Autowired
    private IUserService userService;

    private static final Logger logger = LogManager.getLogger(AirQualityMonitoringController.class);


    @RequestMapping(value = "/airQualityIndex", method = RequestMethod.PATCH)
    @ResponseBody
    public HourlyAirQualityIndex updateAirQualityIndex() throws Exception {

        logger.info("update current index and store to db");

        return airQualityService.updateAirQualityIndex();

    }

    @RequestMapping(value = "/airQualityIndex/process", method = RequestMethod.PATCH)
    @ResponseBody
    public HourlyAirQualityIndex processSubscriptions() throws Exception {

        logger.info("process subscription");

        airQualityService.processSubscriptions();
        return new HourlyAirQualityIndex();

    }

    @RequestMapping(value = "/airQualityIndex", method = RequestMethod.GET)
    @ResponseBody
    public HourlyAirQualityIndex getCurrentAirQualityIndex() throws Exception {

        logger.info("get current index");

        return airQualityService.getCurrentAirQualityIndex();

    }

    @RequestMapping(value = "/airQualityIndexHealthAdvice", method = RequestMethod.PATCH)
    @ResponseBody
    public AirQualityIndexHealthAdvice updateHealthAdvice() throws Exception {

        logger.info("update current health advice and store to db");

        return airQualityService.updateHealthAdvice();

    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getAllUsers() throws Exception {

        logger.info("get all users");

        return userService.getAllUsers();

    }

    @RequestMapping(value = "/users/{userid}/subscriptions", method = RequestMethod.POST, consumes = "application/json")
    public void createNewSubscription(@RequestBody Subscription subscription, @PathVariable("userid") String userId) throws Exception {

        logger.info("create new subscription"+subscription+"_"+userId);

        userService.createNotification(subscription, userId);

    }

    @RequestMapping(value = "/users/{userid}/subscriptions", method = RequestMethod.GET)
    @ResponseBody
    public List<Subscription> getAllSubscriptionsForUser(@PathVariable("userid") String userId) throws Exception {

        logger.info("get all subscriptions for user"+userId);

        return userService.getAllSubscriptionsForUser(userId);

    }


}
