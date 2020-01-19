package com.doctor.service;

import com.doctor.domain.Doctor;
import com.doctor.domain.exception.DoctorExistException;
import com.doctor.domain.exception.DoctorNotExistException;
import com.doctor.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.security.krb5.internal.crypto.dk.DkCrypto;

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

    public Doctor findDoctorById(final Long id) throws DoctorNotExistException {
        return doctorRepository.findById(id).orElseThrow(DoctorNotExistException::new);
    }

    public Doctor findDoctorBySurname(final String surname) throws DoctorNotExistException {
        if (!isDoctorExist(surname)) {
            throw new DoctorNotExistException();
        }
        return doctorRepository.findBySurname(surname);
    }

    public boolean isDoctorExist(final String surname) {
        return doctorRepository.existsBySurname(surname);
    }

    public Doctor createDoctor(final Doctor doctor) throws DoctorExistException {
        if(doctorRepository.existsBySurname(doctor.getSurname())) {
            throw new DoctorExistException();
        }
        return doctorRepository.save(doctor);
    }

    public Doctor updateDoctor(final Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public void deleteDoctor(final Doctor doctor) throws DoctorNotExistException {
        if(!doctorRepository.existsBySurname(doctor.getSurname())) {
            throw new DoctorNotExistException();
        }
        doctorRepository.delete(doctor);
    }
}