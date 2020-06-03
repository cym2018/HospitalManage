package org.example.recode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.example.bed.Bed;
import org.example.common.CommonEntity;
import org.example.common.STATE;
import org.example.patient.Patient;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
@JsonIgnoreProperties(value = "recode")
public class Recode extends CommonEntity {
    @ManyToOne
    private Bed bed;
    @ManyToOne
    private Patient patient;
    @Column
    private Date endTime;


    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
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
        if(endTime==null){
            return STATE.有效;
        }else {
            return STATE.无效;
        }
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

    public Bed getBed() {
        return bed;
    }

    public void setBed(Bed bed) {
        this.bed = bed;
    }
}
