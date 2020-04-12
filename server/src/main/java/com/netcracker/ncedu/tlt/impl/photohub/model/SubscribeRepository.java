package com.netcracker.ncedu.tlt.impl.photohub.model;

import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface SubscribeRepository extends CrudRepository<Subscription, String> {
    boolean deleteByEmailSubscriberAndSubscribeTo(String emailSubscriber, String subscribeTo );
    List<Subscription> findByEmailSubscriberAndName(String email, String name);

}
