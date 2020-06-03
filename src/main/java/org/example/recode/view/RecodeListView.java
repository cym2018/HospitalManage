package org.example.recode.view;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.example.recode.Recode;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@JsonPropertyOrder({"id", "patient", "section", "bedNo", "state", "startTime", "endTime"})
public class RecodeListView {
    private final Recode recode;

    public RecodeListView(Recode recode) {
        this.recode = recode;
    }

    public Integer getId() {
        return recode.getId();
    }

    public String getState() {
        return recode.getState().name();
    }

    public String getPatient() {
        return recode.getPatient().getName();
    }

    public String getBedNo() {
        return recode.getBed().getNo();
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
}
