package com.netcracker.ncedu.tlt.impl.photohub.model;

import org.springframework.data.repository.CrudRepository;

public interface LikeRepository  extends CrudRepository<Likes, LikesId> {
    boolean existsByUserIdAndPhotoId(Integer userId, Integer photoId);
    boolean deleteByUserIdAndPhotoId(Integer userId, Integer photoId);
    long countByPhotoId(Integer photoId);

}
