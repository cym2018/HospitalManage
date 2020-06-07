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
                ", id=" + id +
                ", note='" + note + '\'' +
                ", createTs=" + createTs +
                ", updateTs=" + updateTs +
                '}';
    }
}
