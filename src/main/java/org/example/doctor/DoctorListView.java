package org.example.doctor;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * @description 医生表的列表视图, 屏蔽多余字段, 手动设置顺序
 */
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
