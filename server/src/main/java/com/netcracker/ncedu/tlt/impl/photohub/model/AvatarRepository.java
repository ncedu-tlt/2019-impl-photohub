package com.netcracker.ncedu.tlt.impl.photohub.model;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AvatarRepository extends CrudRepository<Avatar, Integer> {
    boolean existsByEmailAndBase64(String email, String base64);
    List<Avatar> findByEmail(String email);
}
