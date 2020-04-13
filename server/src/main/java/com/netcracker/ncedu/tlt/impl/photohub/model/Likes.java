package com.netcracker.ncedu.tlt.impl.photohub.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(LikesId.class)
public class Likes {


    private String userEmail;
    @Id
    private Integer photoId;

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userId) {
        this.userEmail = userId;
    }

    public Integer getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Integer photoId) {
        this.photoId = photoId;
    }
}
