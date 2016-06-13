package at.ac.tuwien.ase2016.domain.subscriptions;

import org.springframework.data.annotation.Id;

/**
 * Created by DanielHofer on 12.06.2016.
 */

public class Subscription {

    @Id
    private String id;
    private double latitude;
    private double longitude;
    private double radius;
    private String mailAddress;
    private boolean notifyViaEmail;
    private String phoneNumber;
    private boolean notifyViaPhone;
    private double threshold;

    public Subscription(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    public boolean isNotifyViaEmail() {
        return notifyViaEmail;
    }

    public void setNotifyViaEmail(boolean notifyViaEmail) {
        this.notifyViaEmail = notifyViaEmail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isNotifyViaPhone() {
        return notifyViaPhone;
    }

    public void setNotifyViaPhone(boolean notifyViaPhone) {
        this.notifyViaPhone = notifyViaPhone;
    }

    public double getThreshold() {
        return threshold;
    }

    public void setThreshold(double threshold) {
        this.threshold = threshold;
    }
}
