package com.netcracker.ncedu.tlt.impl.photohub.model;


import java.io.Serializable;
import java.util.Objects;

public class SubscribeId implements Serializable {

    private String emailSubscriber;
    private String subscribeTo;

    public SubscribeId() {}

    public SubscribeId(String emailSubscriber, String subscribeTo) {
        this.emailSubscriber = emailSubscriber;
        this.subscribeTo = subscribeTo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubscribeId that = (SubscribeId) o;
        return Objects.equals(emailSubscriber, that.emailSubscriber) &&
                Objects.equals(subscribeTo, that.subscribeTo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(emailSubscriber, subscribeTo);
    }

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
