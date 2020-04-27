package org.example.bed;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BedRepository extends JpaRepository<Bed, Integer> {
    Bed findByNo(String no);
}
