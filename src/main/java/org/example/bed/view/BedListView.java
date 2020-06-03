package org.example.bed.view;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.example.bed.Bed;
import org.example.common.STATE;
import org.example.recode.Recode;

/**
 * @description 病床表的列表视图, 屏蔽多余字段, 手动设置顺序
 */
@JsonPropertyOrder({"id", "no", "section", "patient", "state"})
public class BedListView {
    private final Bed bed;

    public BedListView(Bed bed) {
        this.bed = bed;
    }

    public Integer getId() {
        return bed.getId();
    }

    public String getSection() {
        return bed.getSection().getSectionName();
    }

    public String getNo() {
        return bed.getNo();
    }

    public String getPatient() {
        Recode recode = bed.getRecodes().stream().filter(o -> o.getState() == STATE.有效).findFirst().orElse(null);
        return recode == null ? null : recode.getPatient().getName();
    }

    public String getState() {
        return bed.getState().name();
    }
}
