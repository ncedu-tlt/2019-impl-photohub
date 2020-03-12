package com.netcracker.ncedu.tlt.impl.photohub.model;

import org.springframework.data.repository.CrudRepository;


public interface PhotoRepository extends CrudRepository<Photo, Integer> {
    boolean existsByEmailAndBase64(String email, String base64);
}
