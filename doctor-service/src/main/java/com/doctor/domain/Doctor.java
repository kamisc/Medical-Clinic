package com.doctor.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

/**
 * Author Kamil Seweryn
 */

@Entity
@Table(name = "DOCTORS")
public class Doctor {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "DOCTOR_ID", unique = true)
    private Long id;

    @NotNull
    @Length(min = 3)
    private String name;

    @NotNull
    @Length(min = 3)
    private String surname;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "DOCTOR_SPECIALIZATION",
            joinColumns =  {@JoinColumn(name = "DOCTOR_ID")},
            inverseJoinColumns = {@JoinColumn(name = "SPECIALIZATION_ID")}
    )
    private Set<Specialization> specializations = new HashSet<>();

    public Doctor() {
    }

    public Doctor(String name, String surname /*Set<Specialization> specializations*/) {
        this.name = name;
        this.surname = surname;
        //this.specializations = specializations;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Doctor doctor = (Doctor) o;

        if (!id.equals(doctor.id)) return false;
        if (!name.equals(doctor.name)) return false;
        if (!surname.equals(doctor.surname)) return false;
        return specializations.equals(doctor.specializations);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + surname.hashCode();
        result = 31 * result + specializations.hashCode();
        return result;
    }
}