package at.ac.tuwien.ase2016.service;

import at.ac.tuwien.ase2016.domain.subscriptions.Subscription;

/**
 * Created by DanielHofer on 12.06.2016.
 */
public interface INotificationService {

    public void sendNotification(Subscription subscription);

}
