package org.example.patient;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.example.recode.Recode;

@JsonPropertyOrder({"id", "name", "gender", "idNumber", "state","bed"})
public class PatientListView {
    Patient patient;

    PatientListView(Patient patient) {
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
        switch (patient.getState()) {
            case 0:
                return "出院";
            case 1:
                return "在住";
            default:
                return patient.getState().toString();
        }
    }

    public String getBed() {
        Recode recode = patient.getRecodes().stream().filter(o -> o.getState() == 0).findFirst().orElse(null);
        if (recode != null)
            return recode.getBed().getNo();
        return "";
    }
}
