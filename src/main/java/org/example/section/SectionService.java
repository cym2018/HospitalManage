package org.example.section;

import org.example.bed.BedService;
import org.example.section.view.SectionListView;
import org.example.section.view.SectionLookupView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SectionService {
    @Autowired
    BedService bedService;
    @Autowired
    private SectionRepository sectionRepository;

    public Section save(Section section) {
        return sectionRepository.save(section);
    }

    public Section findById(Integer id) {
        return sectionRepository.findById(id).orElse(null);
    }

    public List<Section> findAll() {
        return sectionRepository.findAll();
    }

    public List<SectionListView> toListView(List<Section> list) {
        List<SectionListView> lookups = new ArrayList<>();
        list.forEach(o -> lookups.add(new SectionListView(o, bedService)));
        return lookups;
    }

    public List<SectionLookupView> toLookupView(List<Section> list) {
        List<SectionLookupView> lookups = new ArrayList<>();
        list.forEach(o -> lookups.add(new SectionLookupView(o)));
        return lookups;
    }

    public void delete(Section section) {
        sectionRepository.delete(section);
    }

}
