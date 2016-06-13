package at.ac.tuwien.ase2016.service.impl;

import at.ac.tuwien.ase2016.domain.subscriptions.Subscription;
import at.ac.tuwien.ase2016.domain.subscriptions.User;
import at.ac.tuwien.ase2016.repository.HourlyAirQualityIndexRepository;
import at.ac.tuwien.ase2016.repository.SubscriptionRepository;
import at.ac.tuwien.ase2016.repository.UserRepository;
import at.ac.tuwien.ase2016.service.IUserService;
import at.ac.tuwien.ase2016.spring.ApplicationProperties;
import com.sun.corba.se.spi.ior.ObjectId;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * Created by DanielHofer on 13.06.2016.
 */

@Service
@Transactional
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Autowired
    protected ApplicationProperties applicationProperties;

    private static final Logger logger = LogManager.getLogger(AirQualityService.class);

    @Override
    public List<User> getAllUsers() throws Exception {
        return userRepository.findAll();
    }

    @Override
    public void createNotification(Subscription subscription, String userId) throws Exception {

        User user = userRepository.findById(userId);

        subscription.setId(UUID.randomUUID().toString());

        if (user.getPhoneNumber() != null && !user.getPhoneNumber().trim().isEmpty()){
            subscription.setPhoneNumber(user.getPhoneNumber());
            subscription.setNotifyViaPhone(true);
        }else{
            subscription.setNotifyViaPhone(false);
        }

        if (user.getMailAddress() != null && !user.getMailAddress().trim().isEmpty()){
            subscription.setMailAddress(user.getMailAddress());
            subscription.setNotifyViaEmail(true);
        }else{
            subscription.setNotifyViaEmail(false);
        }

        subscriptionRepository.save(subscription);

        user.addSubscription(subscription);
        userRepository.save(user);

    }

    public List<Subscription> getAllSubscriptionsForUser(String userId) throws Exception{

        User user = userRepository.findById(userId);

        return user.getSubscriptions();
    }


}
