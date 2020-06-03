package org.example.section.view;

import org.example.common.STATE;
import org.example.section.Section;

public class SectionEditView {
    Section section;

    public SectionEditView(Section section) {
        this.section = section;
    }

    public Integer getId() {
        return section.getId();
    }

    public String getName() {
        return section.getSectionName();
    }

    public String getLocation() {
        return section.getLocation();
    }

    public Integer getBedNumber() {
        return section.getBeds().size();
    }

    public long getFreeBedNumber() {
        return section.getBeds().stream().filter(o -> o.getState() == STATE.空闲).count();
    }
}
