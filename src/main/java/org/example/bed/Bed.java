package org.example.bed;

import org.example.common.CommonEntity;
import org.example.patient.Patient;
import org.example.section.Section;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Set;

/**
 * @description 病床表 对应:床号, 从属部门, 患者
 */
@Entity
public class Bed extends CommonEntity {
    @ManyToOne
    private Section section;
    @Column
    private Integer no;
    @OneToMany
    private Set<Patient> patients;

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public Set<Patient> getPatients() {
        return patients;
    }

    public void setPatients(Set<Patient> patients) {
        this.patients = patients;
    }
}
