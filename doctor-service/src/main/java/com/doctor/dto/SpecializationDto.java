package com.doctor.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Author Kamil Seweryn
 */

public class SpecializationDto {
    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    private Long id;
    private String name;

    public SpecializationDto() {
    }

    public SpecializationDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public SpecializationDto(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}