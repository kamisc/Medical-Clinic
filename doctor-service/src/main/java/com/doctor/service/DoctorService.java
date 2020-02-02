package com.doctor.service;

import com.doctor.domain.Doctor;
import com.doctor.domain.Specialization;
import com.doctor.domain.exception.DoctorExistException;
import com.doctor.domain.exception.DoctorNotExistException;
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
    private SpecializationService specializationService;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository, SpecializationService specializationService) {
        this.doctorRepository = doctorRepository;
        this.specializationService = specializationService;
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

    public Doctor addSpecializationToDoctor(final Long doctorId, final Long specializationId) throws DoctorNotExistException {
        Specialization specialization = specializationService.findSpecializationById(specializationId);
        Doctor doctor = findDoctorById(doctorId);
        doctor.getSpecializations().add(specialization);
        specialization.getDoctors().add(doctor);
        return doctor;
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