package com.doctor.service;

import com.doctor.domain.Specialization;
import com.doctor.domain.exception.CantDeleteSpecializationException;
import com.doctor.domain.exception.SpecializationExistException;
import com.doctor.domain.exception.SpecializationNotExistException;
import com.doctor.repository.SpecializationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author Kamil Seweryn
 */

@Service
public class SpecializationService {
    private SpecializationRepository specializationRepository;

    @Autowired
    public SpecializationService(SpecializationRepository specializationRepository) {
        this.specializationRepository = specializationRepository;
    }

    public List<Specialization> findAllSpecializations() {
        return specializationRepository.findAll();
    }

    public Specialization findSpecializationById(final Long id) throws SpecializationNotExistException {
        return specializationRepository.findById(id).orElseThrow(SpecializationNotExistException::new);
    }

    public Specialization addSpecialization(final Specialization specialization) throws SpecializationExistException {
        if (specializationRepository.existsByName(specialization.getName())) {
            throw new SpecializationExistException(specialization.getName());
        }
        return specializationRepository.save(specialization);
    }

    public void deleteSpecialization(final Specialization specialization) throws CantDeleteSpecializationException {
        if (!specialization.getDoctors().isEmpty()) {
            throw new CantDeleteSpecializationException(specialization.getName());
        }
        specializationRepository.delete(specialization);
    }
}