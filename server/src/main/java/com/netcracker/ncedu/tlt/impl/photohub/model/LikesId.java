package com.netcracker.ncedu.tlt.impl.photohub.model;

import java.io.Serializable;
import java.util.Objects;

public class LikesId implements Serializable {
    private String userEmail;
    private Integer photoId;


    public LikesId() {}


    public LikesId(Integer userId, Integer photoId) {
        this.userEmail = userEmail;
        this.photoId = photoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LikesId likesId = (LikesId) o;
        return Objects.equals(userEmail, likesId.userEmail) &&
                Objects.equals(photoId, likesId.photoId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userEmail, photoId);
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Integer getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Integer photoId) {
        this.photoId = photoId;
    }
}
