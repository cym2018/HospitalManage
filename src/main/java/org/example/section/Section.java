package org.example.section;

import org.example.common.CommonEntity;
import org.example.doctor.Doctor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class Section extends CommonEntity {
    @Column
    private String sectionName;
    @OneToMany
    private Set<Doctor> users;
    @Column
    private String location;

    public Set<Doctor> getUsers() {
        return users;
    }

    public void setUsers(Set<Doctor> users) {
        this.users = users;
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
