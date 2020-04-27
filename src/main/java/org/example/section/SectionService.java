package org.example.section;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SectionService {
    @Autowired
    private SectionRepository sectionRepository;

    public Section save(Section section) {
        return sectionRepository.save(section);
    }

    public Section findById(Integer id) {
        return sectionRepository.findById(id).orElse(null);
    }

    public List<SectionListView> findAllListView() {
        List<SectionListView> sectionList = new ArrayList<>();
        sectionRepository.findAll().forEach(o -> sectionList.add(new SectionListView(o)));
        return sectionList;
    }

    public List<SectionKeyValueView> findAllKeyValueView() {
        List<SectionKeyValueView> sectionList = new ArrayList<>();
        sectionRepository.findAll().forEach(o -> sectionList.add(new SectionKeyValueView(o)));
        return sectionList;
    }
}
