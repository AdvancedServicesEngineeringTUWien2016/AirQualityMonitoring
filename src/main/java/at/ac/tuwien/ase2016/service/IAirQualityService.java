package at.ac.tuwien.ase2016.service;

import at.ac.tuwien.ase2016.domain.londonair.HourlyAirQualityIndex;
import at.ac.tuwien.ase2016.domain.londonair.advice.AirQualityIndexHealthAdvice;

/**
 * Created by DanielHofer on 12.06.2016.
 */
public interface IAirQualityService {

    public HourlyAirQualityIndex updateAirQualityIndex() throws Exception;

    public HourlyAirQualityIndex getCurrentAirQualityIndex() throws Exception;

    public void processSubscriptions() throws Exception;

    public AirQualityIndexHealthAdvice updateHealthAdvice() throws Exception;

    public void createTestData() throws Exception;


}
