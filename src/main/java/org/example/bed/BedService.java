package org.example.bed;

import org.example.bed.view.BedListView;
import org.example.bed.view.BedLookupView;
import org.example.common.BEDSTATE;
import org.example.recode.Recode;
import org.example.section.Section;
import org.example.section.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.example.common.BEDSTATE.空闲;

/**
 * @description 病床管理相关业务逻辑
 */
@Service
public class BedService {

    @Autowired
    private BedRepository bedRepository;
    @Autowired
    private SectionService sectionService;

    public Bed save(Bed bed) throws Exception {
        if (bed.getId() != null) {
            Bed temp = findById(bed.getId());
            bed.setRecodes(temp.getRecodes());
        }
        return bedRepository.save(bed);
    }

    public Bed findByNo(String No) {
        return bedRepository.findByNo(No);
    }

    public Bed addRecode(Bed bed, Recode recode) throws Exception {
        bed.addRecode(recode);
        return save(bed);
    }

    public Bed getOrCreate(Integer id) {
        if (id == null) {
            return new Bed();
        } else {
            return bedRepository.findById(id).orElse(new Bed());
        }
    }

    public void setSection(Bed bed, Integer sectionId) {
        bed.setSection(sectionService.findById(sectionId));
    }

    public void remove(Bed bed) {
        bedRepository.delete(bed);
    }

    public List<Bed> findAll() {
        return bedRepository.findAll();
    }

    public List<BedListView> toListView(List<Bed> beds) {
        List<BedListView> lookups = new ArrayList<>();
        beds.forEach(o -> lookups.add(new BedListView(o)));
        return lookups;
    }


    public List<BedLookupView> toLookupView(List<Bed> beds) {
        List<BedLookupView> lookups = new ArrayList<>();
        beds.stream().filter(o -> o.getState().equals(BEDSTATE.空闲)).forEach(o -> lookups.add(new BedLookupView(o)));
        return lookups;
    }

    public List<BedLookupView> toLookupViews(List<Bed> beds) {
        List<BedLookupView> lookups = new ArrayList<>();
        beds.forEach(o -> lookups.add(new BedLookupView(o)));
        return lookups;
    }

    public Bed findById(Integer id) throws Exception {
        return bedRepository.findById(id).orElseThrow(Exception::new);
    }

    public List<Bed> findBySection(Section section) {
        return bedRepository.findBySection(section);
    }

    public List<Bed> findFree() {
        List<Bed> ret = bedRepository.findAll();
        return ret.stream().filter(o -> {
            return o.getState() == 空闲;
        }).collect(Collectors.toList());
    }
}
