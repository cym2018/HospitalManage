package org.example.section.view;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.example.bed.Bed;
import org.example.bed.BedService;
import org.example.common.BEDSTATE;
import org.example.section.Section;

import java.util.List;

@JsonPropertyOrder({"id", "name", "location", "bedNumber", "freeBedNumber"})
public class SectionListView {
    final Section section;

    final BedService bedService;

    public SectionListView(Section section, BedService bedService) {
        this.section = section;
        this.bedService = bedService;
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
        List<Bed> beds = bedService.findBySection(section);
        if (beds == null) {
            return 0;
        }
        return beds.size();
    }

    public long getFreeBedNumber() {
        return bedService.findBySection(section).stream().filter(o -> o.getState().equals(BEDSTATE.空闲)).count();
    }
}
