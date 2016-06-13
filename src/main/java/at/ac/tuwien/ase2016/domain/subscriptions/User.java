package at.ac.tuwien.ase2016.domain.subscriptions;

import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DanielHofer on 12.06.2016.
 */
public class User {

    @Id
    private String id;
    private String name;
    private List<Subscription> subscriptions;
    private boolean isSubscribedUser;
    private String mailAddress;
    private String phoneNumber;
    private String avatar;

    public User(){
        subscriptions = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String lastName) {
        this.name = lastName;
    }

    public List<Subscription> getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(List<Subscription> subscriptions) {
        this.subscriptions = subscriptions;
    }

    public void addSubscription(Subscription s){
        subscriptions.add(s);
    }

    public boolean isSubscribedUser() {
        return isSubscribedUser;
    }

    public void setSubscribedUser(boolean subscribedUser) {
        isSubscribedUser = subscribedUser;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
