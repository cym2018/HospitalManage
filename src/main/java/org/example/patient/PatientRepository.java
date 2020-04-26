package org.example.patient;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
    Patient findByIdNumber(String idNumber);
}
