package at.ac.tuwien.ase2016.service;

import at.ac.tuwien.ase2016.domain.HourlyAirQualityIndex;
import at.ac.tuwien.ase2016.spring.exception.BadRequestException;

import java.util.List;

/**
 * Created by DanielHofer on 12.06.2016.
 */
public interface IAirQualityService {

    public HourlyAirQualityIndex getCurrentAirQualityIndex() throws Exception;


}
