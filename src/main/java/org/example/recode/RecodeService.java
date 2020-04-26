package org.example.recode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecodeService {

    @Autowired
    private RecodeRepository recodeRepository;

    public Recode save(Recode recode) {
        return recodeRepository.save(recode);
    }

    public List<RecodeListView> recodeList() {
        List<RecodeListView> recodeList = new ArrayList<>();
        recodeRepository.findAll().forEach(o -> recodeList.add(new RecodeListView(o)));
        return recodeList;
    }
}
