package com.doctor.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "doctors")
public class Doctor {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "doctor_id", unique = true)
    private Long id;

    @NotNull
    @Length(min = 3)
    private String name;

    @NotNull
    @Length(min = 3)
    private String surname;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "doctor_specialization",
            joinColumns =  {@JoinColumn(name = "doctor_id")},
            inverseJoinColumns = {@JoinColumn(name = "specialization_id")}
    )
    @JsonManagedReference
    @JsonIgnore
    private Set<Specialization> specializations = new HashSet<>();

    public Doctor() {
    }

    public Doctor(String name, String surname, Set<Specialization> specializations) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Doctor doctor = (Doctor) o;

        if (!id.equals(doctor.id)) return false;
        if (!name.equals(doctor.name)) return false;
        return surname.equals(doctor.surname);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + surname.hashCode();
        return result;
    }
}