package at.ac.tuwien.ase2016.service.impl;

import at.ac.tuwien.ase2016.domain.AirQualityIndex;
import at.ac.tuwien.ase2016.domain.HourlyAirQualityIndex;
import at.ac.tuwien.ase2016.repository.HourlyAirQualityIndexRepository;
import at.ac.tuwien.ase2016.service.IAirQualityService;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;


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


    @Override
    public HourlyAirQualityIndex getCurrentAirQualityIndex() throws Exception {

        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper mapper = new ObjectMapper();
        MappingJackson2HttpMessageConverter convertor = new MappingJackson2HttpMessageConverter();
        convertor.setObjectMapper(mapper);
        mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        restTemplate.setMessageConverters(Collections.singletonList(convertor));


        AirQualityIndex airQualityIndex =
                restTemplate.getForObject("http://api.erg.kcl.ac.uk/AirQuality/Hourly/MonitoringIndex/GroupName=London/Json", AirQualityIndex.class);

        return airQualityIndex.getHourlyAirQualityIndex();

    }
}

