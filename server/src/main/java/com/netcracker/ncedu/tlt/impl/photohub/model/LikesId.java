package com.netcracker.ncedu.tlt.impl.photohub.model;

import java.io.Serializable;
import java.util.Objects;

public class LikesId implements Serializable {
    private Integer userId;
    private Integer photoId;

    public LikesId() {}

    public LikesId(Integer userId, Integer photoId) {
        this.userId = userId;
        this.photoId = photoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LikesId likesId = (LikesId) o;
        return Objects.equals(userId, likesId.userId) &&
                Objects.equals(photoId, likesId.photoId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, photoId);
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Integer photoId) {
        this.photoId = photoId;
    }
}
