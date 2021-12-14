package com.example.quanlynghesi.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "artist")
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", locale = "vi_VN", timezone = "Asia/Ho_Chi_Minh")
    private Date dob;
    private String image;
    @ManyToOne(targetEntity = Job.class)
    @JoinColumn(name = "job_id")
    private Job job;

    public Artist() {
    }

    public Artist(Long id, String name, Date dob, String image, Job job) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.image = image;
        this.job = job;
    }

    public Artist(Long id, String name, Date dob, Job job) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.job = job;
    }

    public Artist(String name, Date dob, Job job) {
        this.name = name;
        this.dob = dob;
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
