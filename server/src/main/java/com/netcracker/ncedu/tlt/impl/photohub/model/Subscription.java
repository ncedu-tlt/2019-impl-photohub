package com.netcracker.ncedu.tlt.impl.photohub.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Subscription {

    @Id
    private Integer Id;

    private String emailSubscriber;

    private String name;

    private String subscribeTo;


    public String getEmailSubscriber() {
        return emailSubscriber;
    }

    public void setEmailSubscriber(String emailSubscriber) {
        this.emailSubscriber = emailSubscriber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubscribeTo() {
        return subscribeTo;
    }

    public void setSubscribeTo(String subscribeTo) {
        this.subscribeTo = subscribeTo;
    }
}
