package com.visit.repository;

import com.visit.domain.Visit;
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
public interface VisitRepository extends JpaRepository<Visit, Long> {
    List<Visit> findAllByUserId(Long userId);

    List<Visit> findAllByDoctorId(Long doctorId);

    @Override
    Optional<Visit> findById(Long id);

    @Override
    Visit save(Visit visit);

    @Override
    void delete(Visit visit);

    @Override
    boolean existsById(Long id);
}