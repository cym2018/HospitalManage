package org.example.recode.view;

import org.example.recode.Recode;

public class RecodeLookupView {
    final private Recode recode;

    public RecodeLookupView(Recode recode) {
        this.recode = recode;
    }

    public Integer getCode() {
        return recode.getId();
    }

    public String getName() {
        return recode.getId().toString();
    }
}
