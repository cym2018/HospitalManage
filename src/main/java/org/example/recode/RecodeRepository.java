package org.example.recode;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RecodeRepository extends JpaRepository<Recode, Integer> {
}
