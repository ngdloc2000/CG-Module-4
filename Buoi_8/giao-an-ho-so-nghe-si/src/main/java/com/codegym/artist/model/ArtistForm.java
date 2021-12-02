package com.codegym.artist.model;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;

public class ArtistForm {
    private Long id;
    @NotNull(message = "Khong de trong")
    @Size(min = 5, max = 45, message = "Do dai toi thieu 5, toi da 45 ky tu")
    private String name;
    private Date dob;
    @NotNull(message = "Khong de trong")
    @Size(min = 3, max = 15, message = "Do dai toi thieu 3, toi da 15 ky tu")
    private String countryside;
    private String fanpage;
    private MultipartFile image;
    private Job job;

    public ArtistForm() {
    }

    public ArtistForm(Long id, String name, Date dob, String countryside, String fanpage, MultipartFile image, Job job) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.countryside = countryside;
        this.fanpage = fanpage;
        this.image = image;
        this.job = job;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ArtistForm(String name, Date dob, String countryside, String fanpage, MultipartFile image, Job job) {
        this.name = name;
        this.dob = dob;
        this.countryside = countryside;
        this.fanpage = fanpage;
        this.image = image;
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getCountryside() {
        return countryside;
    }

    public void setCountryside(String countryside) {
        this.countryside = countryside;
    }

    public String getFanpage() {
        return fanpage;
    }

    public void setFanpage(String fanpage) {
        this.fanpage = fanpage;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }
}
