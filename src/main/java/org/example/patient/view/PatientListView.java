package org.example.patient.view;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.example.common.RECODESTATE;
import org.example.patient.Patient;
import org.example.recode.Recode;

/**
 * @description 患者表的列表视图, 屏蔽多余字段, 手动设置顺序
 */
@JsonPropertyOrder({"id", "name", "gender", "idNumber", "state", "bed"})
public class PatientListView {
    Patient patient;

    public PatientListView(Patient patient) {
        this.patient = patient;
    }

    public Integer getId() {
        return patient.getId();
    }

    public String getName() {
        return patient.getName();
    }

    public String getGender() {
        return patient.getGender();
    }

    public String getIdNumber() {
        return patient.getIdNumber();
    }

    public String getState() {
        return patient.getState().name();
    }

    public String getBed() {
        Recode recode = patient.getRecodes().stream().filter(o -> o.getState() != RECODESTATE.有效).findFirst().orElse(null);
        if (recode != null)
            return recode.getBed().getNo();
        return "";
    }
}
