package com.doctor.dto;

import com.doctor.domain.Specialization;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Set;

/**
 * Author Kamil Seweryn
 */

public class DoctorDto {
    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    private Long id;
    private String name;
    private String surname;
    private Set<Specialization> specializations;

    public DoctorDto() {
    }

    public DoctorDto(Long id, String name, String surname, Set<Specialization> specializations) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.specializations = specializations;
    }

    public DoctorDto(String name, String surname, Set<Specialization> specializations) {
        this.name = name;
        this.surname = surname;
        this.specializations = specializations;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Set<Specialization> getSpecializations() {
        return specializations;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setSpecializations(Set<Specialization> specializations) {
        this.specializations = specializations;
    }
}