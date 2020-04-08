package com.netcracker.ncedu.tlt.impl.photohub.model;

import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface SubscribeRepository extends CrudRepository<Subscription, Integer> {
    boolean deleteByIdSubscriberAndSubscribeTo(Integer idSubscriber, Integer subscribeTo );
    List<Subscription> findByIdSubscriber(Integer idSubscriber);
}
