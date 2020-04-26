package org.example.bed;

import org.example.recode.Recode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BedService {

    @Autowired
    private BedRepository bedRepository;

    public Bed save(Bed bed) {
        return bedRepository.save(bed);
    }

    public Bed findByNo(String No) {
        return bedRepository.findByNo(No);
    }

    public List<BedListView> findAllListView() {
        List<BedListView> bedList = new ArrayList<>();
        bedRepository.findAll().forEach(o -> bedList.add(new BedListView(o)));
        return bedList;
    }

    public Bed addRecode(Bed bed, Recode recode) {
        bed.addRecode(recode);
        return save(bed);
    }
}
