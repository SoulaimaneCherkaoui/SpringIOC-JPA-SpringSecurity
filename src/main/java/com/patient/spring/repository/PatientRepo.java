package com.patient.spring.repository;

import com.patient.spring.entities.patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepo extends JpaRepository<patient,Long> {
    Page<patient> findByNomContains(String keyword, Pageable pageable);
}
