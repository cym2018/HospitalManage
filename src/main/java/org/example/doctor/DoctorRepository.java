package org.example.doctor;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
    Boolean existsByUsernameAndPassword(String username, String password);
}