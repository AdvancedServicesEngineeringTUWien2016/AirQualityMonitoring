package at.ac.tuwien.ase2016.repository;

import at.ac.tuwien.ase2016.domain.londonair.advice.AirQualityIndexHealthAdvice;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by DanielHofer on 12.06.2016.
 */

public interface AirQualityIndexHealthAdviceRepository extends MongoRepository<AirQualityIndexHealthAdvice, String> {



}
