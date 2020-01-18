package com.doctor.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

/**
 * Author Kamil Seweryn
 */

@Entity
@Table(name = "SPECIALIZATIONS")
public class Specialization {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "SPECIALIZATION_ID", unique = true)
    private Long id;

    @NotNull
    private String name;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "specializations")
    private Set<Doctor> doctors = new HashSet<>();

    public Specialization() {
    }

    public Specialization(String name) {
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