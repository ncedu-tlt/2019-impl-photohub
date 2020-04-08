package com.netcracker.ncedu.tlt.impl.photohub.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Subscription {

    @Id
    private Integer Id;

    private Integer idSubscriber;

    private Integer subscribeTo;

    public Integer getIdSubscriber() {
        return idSubscriber;
    }

    public void setIdSubscriber(Integer idSubscriber) {
        this.idSubscriber = idSubscriber;
    }

    public Integer getSubscribeTo() {
        return subscribeTo;
    }

    public void setSubscribeTo(Integer subscribeTo) {
        this.subscribeTo = subscribeTo;
    }
}
