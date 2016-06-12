package at.ac.tuwien.ase2016.service;

import at.ac.tuwien.ase2016.domain.HourlyAirQualityIndex;

/**
 * Created by DanielHofer on 12.06.2016.
 */
public interface IAirQualityService {

    public HourlyAirQualityIndex updateAirQualityIndex() throws Exception;

    public HourlyAirQualityIndex getCurrentAirQualityIndex() throws Exception;


}
