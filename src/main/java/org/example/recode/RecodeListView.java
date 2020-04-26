package org.example.recode;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@JsonPropertyOrder({"id","patient","section","bedNo","state","startTime","endTime"})
public class RecodeListView {
    Recode recode;

    RecodeListView(Recode recode) {
        this.recode = recode;
    }

    public Integer getId() {
        return recode.getId();
    }

    public String getState() {
        switch (recode.getState()){
            case 0:return "有效";
            case 1:return "完成";
            case 2:return "撤销";
            default:return recode.getState().toString();
        }
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
    public Date getStartTime(){
        return recode.getCreateTs();
    }
    @JsonFormat(pattern = "YYYY-MM-dd HH:mm:ss")
    public Date getEndTime(){
        return recode.getEndTime();
    }
}
