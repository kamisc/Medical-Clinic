package com.visit.service;

import com.visit.domain.Visit;
import com.visit.repository.VisitRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author Kamil Seweryn
 */

@Service
public class VisitService {
    private VisitRepository visitRepository;

    public VisitService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    public List<Visit> findAllVisitsByUserId(final Long userId) {
        return visitRepository.findAllByUserId(userId);
    }

    public List<Visit> findAllVisitsByDoctorId(final Long doctorId) {
        return visitRepository.findAllByDoctorId(doctorId);
    }

    public Visit findVisitById(final Long id) {
        return visitRepository.findById(id).orElseThrow(IllegalAccessError::new);
    }

    public Visit createVisit(final Visit visit) {
        return visitRepository.save(visit);
    }

    public void deleteVisit(final Visit visit) {
        deleteVisit(visit);
    }
}