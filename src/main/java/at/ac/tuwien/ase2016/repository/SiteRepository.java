package at.ac.tuwien.ase2016.repository;



import at.ac.tuwien.ase2016.domain.londonair.Site;
import org.springframework.data.geo.Circle;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by DanielHofer on 12.06.2016.
 */

public interface SiteRepository extends MongoRepository<Site, String> {

    List<Site> findSiteBySiteCode(String siteCode);

    List<Site> findByAddressLocationWithin(Circle c);

    List<Site> findByAddressLocationNear(Point p, Distance c);



}