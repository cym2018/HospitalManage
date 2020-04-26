package org.example.patient;

import org.example.bed.Bed;
import org.example.common.CommonEntity;
import org.example.common.PeopleEntity;
import org.example.recode.Recode;
import org.hibernate.annotations.Cache;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @description 患者表, 对应:姓名,年龄,性别,身份证号,床号
 */
@Entity
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
    public void addRecode(Recode recode){
        if(recodes==null){
            recodes=new HashSet<>();
        }
        recodes.add(recode);
        state=1;
    }

}
