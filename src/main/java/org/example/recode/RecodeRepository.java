package org.example.recode;

import org.example.patient.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface RecodeRepository extends JpaRepository<Recode, Integer> {
    List<Recode> findByPatient(Patient patient);
}
