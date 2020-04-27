package org.example.section;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.example.bed.Bed;
import org.example.common.CommonEntity;
import org.example.doctor.Doctor;

import javax.persistence.*;
import java.util.Set;

@Entity
@JsonIgnoreProperties(value = "section")
public class Section extends CommonEntity {
    @Column
    private String sectionName;
    @Column
    private String location;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "section_id")
    private Set<Doctor> doctors;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "section_id")
    private Set<Bed> beds;

    public Set<Bed> getBeds() {
        return beds;
    }

    public void setBeds(Set<Bed> beds) {
        this.beds = beds;
    }

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

    @Override
    public String toString() {
        return "Section{" +
                "sectionName='" + sectionName + '\'' +
                ", location='" + location + '\'' +
                ", doctors=" + doctors +
                ", beds=" + beds +
                ", id=" + id +
                ", state=" + state +
                ", note='" + note + '\'' +
                ", createTs=" + createTs +
                ", updateTs=" + updateTs +
                '}';
    }

    public void addBed(Bed bed) {
        beds.add(bed);
    }
}
