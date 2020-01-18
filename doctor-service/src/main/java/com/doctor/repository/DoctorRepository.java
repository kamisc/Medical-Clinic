package com.doctor.repository;

import com.doctor.domain.Doctor;
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
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    @Override
    List<Doctor> findAll();

    @Override
    Optional<Doctor> findById(Long id);

    Doctor findBySurname(String surname);

    @Override
    Doctor save(Doctor doctor);

    @Override
    void delete(Doctor doctor);

    boolean existsBySurname(String surname);
}
