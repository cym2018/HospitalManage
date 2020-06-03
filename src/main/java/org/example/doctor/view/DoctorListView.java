package org.example.doctor.view;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.example.doctor.Doctor;

@JsonPropertyOrder({"id", "username", "name", "gender", "age", "idNumber"})
public class DoctorListView {
    private final Doctor doctor;

    public DoctorListView(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getUsername() {
        return doctor.getUsername();
    }

    public Integer getId() {
        return doctor.getId();
    }

    public String getGender() {
        return doctor.getGender();
    }

    public String getIdNumber() {
        return doctor.getIdNumber();
    }

    public String getName() {
        return doctor.getName();
    }

    public Integer getAge() {
        return doctor.getAge();
    }

    public String getSection() {
        return doctor.getSection().getSectionName();
    }
}
