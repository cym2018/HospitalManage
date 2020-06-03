package org.example.doctor.view;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.example.doctor.Doctor;
import org.example.section.Section;

@JsonPropertyOrder({"id", "name", "username", "password", "gender", "age", "idNumber", "section","note"})
public class DoctorEditView {
    private final Doctor doctor;

    public DoctorEditView(Doctor doctor) {
        this.doctor = doctor;
    }

    public Integer getId() {
        return doctor.getId();
    }

    public String getName() {
        return doctor.getName();
    }

    public String getUsername() {
        return doctor.getUsername();
    }

    public String getPassword() {
        return doctor.getPassword();
    }

    public String getGender() {
        return doctor.getGender();
    }

    public Integer getAge() {
        return doctor.getAge();
    }

    public String getIdNumber() {
        return doctor.getIdNumber();
    }

    public String getNote() {
        return doctor.getNote();
    }

    public String getSection() {
        return doctor.getSection().getId().toString();
    }
}
