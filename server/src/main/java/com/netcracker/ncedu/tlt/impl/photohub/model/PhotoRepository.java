package com.netcracker.ncedu.tlt.impl.photohub.model;

import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface PhotoRepository extends CrudRepository<Photo, Integer> {
    boolean existsByEmailAndBase64(String email, String base64);
    List<Photo> findByEmail(String email);
    long countById(Integer id);
}


