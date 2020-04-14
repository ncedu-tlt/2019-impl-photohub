package com.netcracker.ncedu.tlt.impl.photohub.model;

import org.springframework.data.repository.CrudRepository;

public interface LikeRepository  extends CrudRepository<Likes, LikesId> {
    Boolean existsByUserEmailAndPhotoId(String userEmail, Integer photoId);
    Integer deleteByUserEmailAndPhotoId(String userEmail, Integer photoId);
    Long countByPhotoId(Integer photoId);

}
