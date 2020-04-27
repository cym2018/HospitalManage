package org.example.section;

public class SectionKeyValueView {
    private final Section section;

    public SectionKeyValueView(Section section) {
        this.section = section;
    }

    public Integer getCode() {
        return section.getId();
    }

    public String getName() {
        return section.getSectionName();
    }
}
