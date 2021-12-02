package com.codegym.artist.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "artist")
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Date dob;
    private String countryside;
    private String fanpage;
    private String image;
    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;

    public Artist() {
    }

    public Artist(Long id, String name, Date dob, String countryside, String fanpage, String image, Job job) {
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }
}