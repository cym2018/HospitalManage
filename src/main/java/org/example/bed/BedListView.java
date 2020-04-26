package org.example.bed;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.example.recode.Recode;

@JsonPropertyOrder({"id", "no", "section", "patient","state"})
public class BedListView {
    Bed bed;

    public BedListView(Bed bed) {
        this.bed = bed;
    }

    public String getSection() {
        return bed.getSection().getSectionName();
    }

    public String getNo() {
        return bed.getNo();
    }

    public String getPatient() {
        Recode recode = bed.getRecodes().stream().filter(o -> o.getState() == 0).findFirst().orElse(null);
        return recode == null ? null : recode.getPatient().getName();
    }
    public String getState(){
        switch (bed.getState()){
            case 0:
                return "空闲";
            case 1:
                return "占用";
            case 2:
                return "停用";
            default:
                return null;
        }
    }
}
