package org.example.bed;

import org.example.section.Section;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BedRepository extends JpaRepository<Bed, Integer> {
    Bed findByNo(String no);
    List<Bed> findBySection(Section section);
}
