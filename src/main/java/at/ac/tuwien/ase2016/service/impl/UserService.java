package at.ac.tuwien.ase2016.service.impl;

import at.ac.tuwien.ase2016.domain.subscriptions.User;
import at.ac.tuwien.ase2016.repository.HourlyAirQualityIndexRepository;
import at.ac.tuwien.ase2016.repository.UserRepository;
import at.ac.tuwien.ase2016.service.IUserService;
import at.ac.tuwien.ase2016.spring.ApplicationProperties;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by DanielHofer on 13.06.2016.
 */

@Service
@Transactional
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    protected ApplicationProperties applicationProperties;

    private static final Logger logger = LogManager.getLogger(AirQualityService.class);

    @Override
    public List<User> getAllUsers() throws Exception {
        return userRepository.findAll();
    }


}
