package com.visit.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Author Kamil Seweryn
 */

@Entity
@Table(name = "VISITS")
public class Visit {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true)
    private Long id;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date = new Date();

    @NotNull
    private String description;

    @NotNull
    private Long userId;

    @NotNull
    private Long doctorId;

    public Visit() {
    }

    public Visit(Date date, String description, Long userId, Long doctorId) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Visit visit = (Visit) o;

        if (!id.equals(visit.id)) return false;
        if (!date.equals(visit.date)) return false;
        if (!description.equals(visit.description)) return false;
        if (!userId.equals(visit.userId)) return false;
        return doctorId.equals(visit.doctorId);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + date.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + userId.hashCode();
        result = 31 * result + doctorId.hashCode();
        return result;
    }
}