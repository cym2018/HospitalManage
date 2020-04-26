package org.example.bed;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BedRepository extends JpaRepository<Bed, Integer> {
    Bed findByNo(String no);
}
