package org.example.recode;

import org.example.common.STATE;
import org.example.recode.view.RecodeEditView;
import org.example.recode.view.RecodeListView;
import org.example.recode.view.RecodeLookupView;
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

    public List<Recode> findAll() {
        return recodeRepository.findAll();
    }

    public List<RecodeListView> toListView(List<Recode> recodes) {
        List<RecodeListView> recodeList = new ArrayList<>();
        recodeRepository.findAll().forEach(o -> recodeList.add(new RecodeListView(o)));
        return recodeList;
    }

    public List<RecodeEditView> toEditView(List<Recode> recodes) {
        List<RecodeEditView> recodeList = new ArrayList<>();
        recodeRepository.findAll().forEach(o -> recodeList.add(new RecodeEditView(o)));
        return recodeList;
    }

    public List<RecodeLookupView> toLookupView(List<Recode> recodes) {
        List<RecodeLookupView> recodeList = new ArrayList<>();
        recodeRepository.findAll().forEach(o -> recodeList.add(new RecodeLookupView(o)));
        return recodeList;
    }

    public void delete(Recode recode) {
        recodeRepository.delete(recode);
    }

}
