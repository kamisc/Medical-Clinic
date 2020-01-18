package com.doctor.dto;

import com.doctor.domain.Doctor;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashSet;
import java.util.Set;

/**
 * Author Kamil Seweryn
 */

public class SpecializationDto {
    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    private Long id;
    private String name;
    private Set<Doctor> doctors = new HashSet<>();

    public SpecializationDto() {
    }

    public SpecializationDto(Long id, String name, Set<Doctor> doctors) {
        this.id = id;
        this.name = name;
        this.doctors = doctors;
    }

    public SpecializationDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<Doctor> getDoctors() {
        return doctors;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDoctors(Set<Doctor> doctors) {
        this.doctors = doctors;
    }
}