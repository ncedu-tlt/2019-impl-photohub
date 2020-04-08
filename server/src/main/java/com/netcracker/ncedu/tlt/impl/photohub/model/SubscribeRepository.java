package com.netcracker.ncedu.tlt.impl.photohub.model;

import org.springframework.data.repository.CrudRepository;



public interface SubscribeRepository extends CrudRepository<Subscription, Integer> {
    boolean deleteByIdSubscriberAndSubscribeTo(Integer idSubscriber, Integer subscribeTo );
}
