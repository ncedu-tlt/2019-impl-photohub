package com.netcracker.ncedu.tlt.impl.photohub.model;

import org.springframework.data.repository.CrudRepository;

public interface LikeRepository  extends CrudRepository<Likes, Integer> {
    boolean existsByEmailAndIdAndLiked(String email, Integer id, Boolean liked);

}
