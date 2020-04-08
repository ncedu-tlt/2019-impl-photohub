package com.netcracker.ncedu.tlt.impl.photohub.model;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Photo {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private boolean archive = false;

    private Date date;

    @Column(length = Integer.MAX_VALUE)
    private String base64;

    private String email;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isArchive() {
        return archive;
    }

    public void setArchive(boolean archive) {
        this.archive = archive;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getBase64() {
        return base64;
    }

    public void setBase64(String base64) {
        this.base64 = base64;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
