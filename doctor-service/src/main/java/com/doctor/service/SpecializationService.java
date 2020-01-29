package com.doctor.service;

import com.doctor.domain.Specialization;
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

    public Specialization findSpecializationById(final Long id) {
        return specializationRepository.findById(id).orElseThrow(IllegalStateException::new);
    }

    public Specialization addSpecialization(final Specialization specialization) {
        return specializationRepository.save(specialization);
    }

    public void deleteSpecialization(final Specialization specialization) {
        specializationRepository.delete(specialization);
    }
}