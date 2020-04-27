package org.example.section;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id", "name", "location","bedNumber","freeBedNumber"})
public class SectionListView {
    Section section;

    public SectionListView(Section section) {
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
        return section.getBeds().stream().filter(o -> o.getState() == 0).count();
    }
}
