package org.example.patient;

import org.example.bed.Bed;
import org.example.common.CommonEntity;
import org.example.common.PeopleEntity;
import org.example.recode.Recode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Set;

/**
 * @description 患者表, 对应:姓名,年龄,性别,身份证号,床号
 */
@Entity
public class Patient extends PeopleEntity {


    @OneToMany
    private Set<Recode> recodes;

    public Set<Recode> getRecodes() {
        return recodes;
    }

    public void setRecodes(Set<Recode> recodes) {
        this.recodes = recodes;
    }


}
