package org.example.recode.view;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.example.recode.Recode;

import java.util.Date;

@JsonPropertyOrder({"id", "patient", "section", "bedNo", "state", "startTime", "endTime", "note"})
public class RecodeEditView {
    private final Recode recode;

    public RecodeEditView(Recode recode) {
        this.recode = recode;
    }

    public Integer getId() {
        return recode.getId();
    }

    public String getState() {
        return recode.getState().name();
    }

    public String getPatient() {
        return recode.getPatient().getId().toString();
    }

    public String getBedNo() {
        return recode.getBed().getId().toString();
    }

    public String getSection() {
        return recode.getBed().getSection().getSectionName();
    }

    @JsonFormat(pattern = "YYYY-MM-dd HH:mm:ss")
    public Date getStartTime() {
        return recode.getCreateTs();
    }

    @JsonFormat(pattern = "YYYY-MM-dd HH:mm:ss")
    public Date getEndTime() {
        return recode.getEndTime();
    }

    public String getNote() {
        return recode.getNote();
    }
}
