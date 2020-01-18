package com.user.domain;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

/**
 * Author Kamil Seweryn
 */

@Entity
@Table(name = "USERS")
public class User {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true)
    private Long id;

    @NotNull
    @Length(min = 3)
    private String name;

    @NotNull
    @Length(min = 3)
    private String surname;

    @NotNull
    @Column(unique = true)
    private String email;

    @NotNull
    @Digits(fraction = 0, integer = 10)
    private Integer phoneNumber;

    @NotNull
    @Length(min = 8)
    private String password;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Role role;

    public User() {
    }

    public User(String name, String surname, String email, Integer phoneNumber, String password, Role role) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.role = role;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!id.equals(user.id)) return false;
        if (!name.equals(user.name)) return false;
        if (!surname.equals(user.surname)) return false;
        if (!email.equals(user.email)) return false;
        if (!phoneNumber.equals(user.phoneNumber)) return false;
        if (!password.equals(user.password)) return false;
        return role.equals(user.role);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + surname.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + phoneNumber.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + role.hashCode();
        return result;
    }
}