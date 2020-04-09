package com.netcracker.ncedu.tlt.impl.photohub.model;

import org.springframework.data.repository.CrudRepository;

public interface LikeRepository  extends CrudRepository<Likes, Integer> {
    boolean existsByEmailAndIid(String email, Integer iid);
    boolean deleteByEmailAndIid(String email, Integer iid);

}
