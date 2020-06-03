package org.example.section.view;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.example.common.STATE;
import org.example.section.Section;

@JsonPropertyOrder({"id", "name", "location", "bedNumber", "freeBedNumber"})
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
        return section.getBeds().stream().filter(o -> o.getState().equals(STATE.空闲)).count();
    }
}
