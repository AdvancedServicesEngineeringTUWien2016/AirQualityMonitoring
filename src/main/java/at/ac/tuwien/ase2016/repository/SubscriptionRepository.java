package at.ac.tuwien.ase2016.repository;


import at.ac.tuwien.ase2016.domain.subscriptions.Subscription;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by DanielHofer on 12.06.2016.
 */

public interface SubscriptionRepository extends MongoRepository<Subscription, String> {





}