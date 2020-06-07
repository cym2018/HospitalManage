package org.example.section.view;

import org.example.section.Section;

public class SectionEditView {
    Section section;

    public SectionEditView(Section section) {
        this.section = section;
    }

    public Integer getId() {
        return section.getId();
    }

    public String getSectionName() {
        return section.getSectionName();
    }

    public String getLocation() {
        return section.getLocation();
    }

    public String getNote(){
        return section.getNote();
    }
}
