package org.example.patient.view;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.example.doctor.Doctor;
import org.example.patient.Patient;

@JsonPropertyOrder({"code", "name"})
public class PatientLookupView {
    final private Patient patient;

    public PatientLookupView(Patient patient) {
        this.patient = patient;
    }

    public Integer getCode() {
        return patient.getId();
    }

    public String getName() {
        return patient.getName();
    }
}
