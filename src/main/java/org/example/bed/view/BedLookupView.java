package org.example.bed.view;

import org.example.bed.Bed;

public class BedLookupView {
    final private Bed bed;

    public BedLookupView(Bed bed) {
        this.bed = bed;
    }

    public Integer getCode() {
        return bed.getId();
    }

    public String getName() {
        return bed.getNo();
    }
}
