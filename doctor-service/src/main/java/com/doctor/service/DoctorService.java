package com.doctor.service;

import com.doctor.domain.Doctor;
import com.doctor.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author Kamil Seweryn
 */

@Service
public class DoctorService {
    private DoctorRepository doctorRepository;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public List<Doctor> findAllDoctors() {
        return doctorRepository.findAll();
    }

    public Doctor findDoctorById(final Long id) {
        return doctorRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    public Doctor findDoctorBySurname(final String surname) {
        return doctorRepository.findBySurname(surname);
    }

    public boolean isDoctorExist(final String surname) {
        return doctorRepository.existsBySurname(surname);
    }

    public Doctor createDoctor(final Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public Doctor updateDoctor(final Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public void deleteDoctor(final Doctor doctor) {
        doctorRepository.delete(doctor);
    }
}