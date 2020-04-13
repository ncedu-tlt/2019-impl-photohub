package com.netcracker.ncedu.tlt.impl.photohub.model;

import org.springframework.data.repository.CrudRepository;

public interface LikeRepository  extends CrudRepository<Likes, LikesId> {
    boolean existsByUserEmailAndPhotoId(String userEmail, Integer photoId);
    boolean deleteByUserEmailAndPhotoId(String userEmail, Integer photoId);
    long countByPhotoId(Integer photoId);

}
