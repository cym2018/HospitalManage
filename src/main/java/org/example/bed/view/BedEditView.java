package org.example.bed.view;

import org.example.bed.Bed;
import org.example.common.STATE;

public class BedEditView {
    private final Bed bed;

    public BedEditView(Bed bed) {
        this.bed = bed;
    }

    public Integer getId() {
        return bed.getId();
    }

    public Integer getSectionId() {
        return bed.getSection().getId();
    }

    public String getNo() {
        return bed.getNo();
    }

    public String getNote() {
        return bed.getNote();
    }

    public STATE getState() {
        return bed.getState();
    }
}
