package com.netcracker.ncedu.tlt.impl.photohub.model;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ContentRepository extends CrudRepository<Photo, Integer> {
    boolean existsByIdAndBase64(Integer id, String base64);
    List<Photo> findByEmailAndId(Integer id);

}