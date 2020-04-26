package org.example.section;

import org.example.common.CommonEntity;
import org.example.doctor.Doctor;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Section extends CommonEntity {
    @Column
    private String sectionName;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Set<Doctor> doctors;
    @Column
    private String location;

    public Set<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(Set<Doctor> doctors) {
        this.doctors = doctors;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

}
