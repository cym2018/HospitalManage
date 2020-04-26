package org.example.bed;

import org.example.common.CommonEntity;
import org.example.patient.Patient;
import org.example.recode.Recode;
import org.example.section.Section;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @description 病床表 对应:床号, 从属部门, 患者
 */
@Entity
public class Bed extends CommonEntity {
    @ManyToOne
    private Section section;
    @Column
    private String no;
    @OneToMany
    @JoinColumn(name = "bed_id")
    private Set<Recode> recodes;

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public Set<Recode> getRecodes() {
        return recodes;
    }

    public void setRecodes(Set<Recode> recodes) {
        this.recodes = recodes;
    }
    public void addRecode(Recode recode){
        if (recodes==null){
            recodes=new HashSet<>();
        }
        this.recodes.add(recode);
        state=1;
    }
}
