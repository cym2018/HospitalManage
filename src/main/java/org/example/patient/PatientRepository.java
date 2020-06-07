package org.example.patient;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
    Patient findByIdNumber(String idNumber);

    boolean existsByNameAndIdNumber(String name, String idNumber);
}
