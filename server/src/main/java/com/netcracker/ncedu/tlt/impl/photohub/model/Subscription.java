package com.netcracker.ncedu.tlt.impl.photohub.model;

import javax.persistence.*;

@Entity
@IdClass(SubscribeId.class)
public class Subscription {


    private String emailSubscriber;

    private String subscribeTo;

    public String getEmailSubscriber() {
        return emailSubscriber;
    }

    public void setEmailSubscriber(String emailSubscriber) {
        this.emailSubscriber = emailSubscriber;
    }

    public String getSubscribeTo() {
        return subscribeTo;
    }

    public void setSubscribeTo(String subscribeTo) {
        this.subscribeTo = subscribeTo;
    }
}
