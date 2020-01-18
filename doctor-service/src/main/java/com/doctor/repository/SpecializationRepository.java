package com.doctor.repository;

import com.doctor.domain.Specialization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Author Kamil Seweryn
 */

@Repository
@Transactional
public interface SpecializationRepository extends JpaRepository<Specialization, Long> {
    @Override
    Specialization save(Specialization doctor);
}