package com.doctor.repository;

import com.doctor.domain.Specialization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * Author Kamil Seweryn
 */

@Repository
@Transactional
public interface SpecializationRepository extends JpaRepository<Specialization, Long> {

    @Override
    List<Specialization> findAll();

    @Override
    Optional<Specialization> findById(Long id);

    @Override
    Specialization save(Specialization specialization);

    @Override
    void delete(Specialization specialization);

    boolean existsByName(String name);
}