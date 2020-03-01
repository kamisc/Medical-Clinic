package com.gateway.dto;

import java.util.Date;

/**
 * Author Kamil Seweryn
 */

public class VisitDto {
    private Long id;
    private Date date;
    private String description;
    private Long userId;
    private Long doctorId;

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