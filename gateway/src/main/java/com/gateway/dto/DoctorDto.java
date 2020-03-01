package com.gateway.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Author Kamil Seweryn
 */

public class DoctorDto {
    private Long id;
    private String name;
    private String surname;
    private List<VisitDto> visitDtoList = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public List<VisitDto> getVisitDtoList() {
        return visitDtoList;
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
}