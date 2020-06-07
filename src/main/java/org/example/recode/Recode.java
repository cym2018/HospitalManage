package org.example.recode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.example.bed.Bed;
import org.example.common.CommonEntity;
import org.example.common.RECODESTATE;
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
    @Column
    private RECODESTATE state;

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

    public RECODESTATE getState() {
        return state;
    }

    public void setState(RECODESTATE state) {
        this.state = state;
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
