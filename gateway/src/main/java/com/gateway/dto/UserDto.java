package com.gateway.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Author Kamil Seweryn
 */

public class UserDto {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private Integer phoneNumber;
    private String password;
    private Role role;
    private final List<VisitDto> visitDtoList = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
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

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}