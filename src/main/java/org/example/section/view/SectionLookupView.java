package org.example.section.view;

import org.example.section.Section;

public class SectionLookupView {
    private final Section section;

    public SectionLookupView(Section section) {
        this.section = section;
    }

    public Integer getCode() {
        return section.getId();
    }

    public String getName() {
        return section.getSectionName();
    }
}
