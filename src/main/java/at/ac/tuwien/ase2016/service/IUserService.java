package at.ac.tuwien.ase2016.service;

import at.ac.tuwien.ase2016.domain.londonair.HourlyAirQualityIndex;
import at.ac.tuwien.ase2016.domain.londonair.advice.AirQualityIndexHealthAdvice;
import at.ac.tuwien.ase2016.domain.subscriptions.Subscription;
import at.ac.tuwien.ase2016.domain.subscriptions.User;

import java.util.List;

/**
 * Created by DanielHofer on 13.06.2016.
 */
public interface IUserService {

    public List<User> getAllUsers() throws Exception;

    public void createNotification(Subscription subscription, String userId) throws Exception;

    public List<Subscription> getAllSubscriptionsForUser(String userId) throws Exception;


}
