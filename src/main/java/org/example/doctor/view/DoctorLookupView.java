package org.example.doctor.view;

import org.example.doctor.Doctor;

public class DoctorLookupView {
    final private Doctor doctor;

    public DoctorLookupView(Doctor doctor) {
        this.doctor = doctor;
    }

    public Integer getCode() {
        return doctor.getId();
    }

    public String getName() {
        return doctor.getName();
    }
}
