package org.example.patient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.example.common.PeopleEntity;
import org.example.common.STATE;
import org.example.recode.Recode;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @description 患者表, 对应:住院记录
 */
@Entity
@JsonIgnoreProperties(value = "patient")
public class Patient extends PeopleEntity {
    @OneToMany
    @JoinColumn(name = "patient_id")
    private Set<Recode> recodes;

    public Set<Recode> getRecodes() {
        return recodes;
    }

    public void setRecodes(Set<Recode> recodes) {
        this.recodes = recodes;
    }

    public void addRecode(Recode recode) {
        if (recodes == null) {
            recodes = new HashSet<>();
        }
        recodes.add(recode);
    }

    @Override
    public String getNote() {
        return super.getNote();
    }

    @Override
    public void setNote(String note) {
        super.setNote(note);
    }

    @Override
    public STATE getState() {
        if(recodes.stream().anyMatch(o->o.getState().equals(STATE.有效))){
            return STATE.住院;
        }
        return STATE.未住院;
    }

    @Override
    public void setState(STATE state) {
        super.setState(state);
    }

    @Override
    public Integer getId() {
        return super.getId();
    }

    @Override
    public void setId(Integer id) {
        super.setId(id);
    }

    @Override
    public Date getUpdateTs() {
        return super.getUpdateTs();
    }

    @Override
    public Date getCreateTs() {
        return super.getCreateTs();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public String getIdNumber() {
        return super.getIdNumber();
    }

    @Override
    public void setIdNumber(String idNumber) {
        super.setIdNumber(idNumber);
    }

    @Override
    public String getGender() {
        return super.getGender();
    }

    @Override
    public void setGender(String gender) {
        super.setGender(gender);
    }

    @Override
    public Integer getAge() {
        return super.getAge();
    }

    @Override
    public void setAge(Integer age) {
        super.setAge(age);
    }
}
