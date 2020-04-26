package org.example.doctor;

import com.fasterxml.jackson.annotation.JsonView;
import org.example.bed.Bed;
import org.example.common.PeopleEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

/**
 * @description
 */
@SuppressWarnings("unused")
@Entity
public class Doctor extends PeopleEntity {
    @Column
    private String username;
    @Column
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public Bed getBed() {
        return super.getBed();
    }

    @Override
    public void setAge(Integer age) {
        super.setAge(age);
    }

    @Override
    public void setBed(Bed bed) {
        super.setBed(bed);
    }

    @Override
    public void setGender(String gender) {
        super.setGender(gender);
    }

    @Override
    public void setId(Integer id) {
        super.setId(id);
    }

    @Override
    public void setIdNumber(String idNumber) {
        super.setIdNumber(idNumber);
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public void setNote(String note) {
        super.setNote(note);
    }

    @Override
    public void setState(Integer state) {
        super.setState(state);
    }

    @Override
    public Date getCreateTs() {
        return super.getCreateTs();
    }

    @Override
    public Date getUpdateTs() {
        return super.getUpdateTs();
    }

    @Override
    public Integer getAge() {
        return super.getAge();
    }

    @Override
    public Integer getId() {
        return super.getId();
    }

    @Override
    public Integer getState() {
        return super.getState();
    }

    @Override
    public String getGender() {
        return super.getGender();
    }

    @Override
    public String getIdNumber() {
        return super.getIdNumber();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getNote() {
        return super.getNote();
    }
}
