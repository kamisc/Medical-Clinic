package com.visit.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * Author Kamil Seweryn
 */

public class VisitDto {

    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    private Long id;
    private Date date;
    private String description;
    private Long userId;
    private Long doctorId;

    public VisitDto() {
    }

    public VisitDto(Long id, Date date, String description, Long userId, Long doctorId) {
        this.id = id;
        this.date = date;
        this.description = description;
        this.userId = userId;
        this.doctorId = doctorId;
    }

    public VisitDto(Date date, String description, Long userId, Long doctorId) {
        this.date = date;
        this.description = description;
        this.userId = userId;
        this.doctorId = doctorId;
    }

    public Long getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }
}