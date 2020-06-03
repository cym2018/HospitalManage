package org.example.bed;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.example.common.CommonEntity;
import org.example.common.STATE;
import org.example.recode.Recode;
import org.example.section.Section;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @description 病床表 床号, 所属部门,对应记录
 */
@Entity
@JsonIgnoreProperties(value = "bed")
public class Bed extends CommonEntity {
    @ManyToOne
    private Section section;
    @Column(unique = true)
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

    public void addRecode(Recode recode) {
        if (recodes == null) {
            recodes = new HashSet<>();
        }
        this.recodes.add(recode);
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
    public Integer getId() {
        return super.getId();
    }

    @Override
    public void setId(Integer id) {
        super.setId(id);
    }

    @Override
    public STATE getState() {
        if (STATE.禁用.equals(this.state)) {
            return this.state;
        }
        if (recodes.stream().anyMatch(o -> o.getState().equals(STATE.有效))) {
            return STATE.占用;
        }
        return STATE.空闲;

    }

    @Override
    public void setState(STATE state) {
        super.setState(state);
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
    public String toString() {
        return "Bed{" +
                "section=" + section +
                ", no='" + no + '\'' +
                ", recodes=" + recodes +
                ", id=" + id +
                ", state=" + state +
                ", note='" + note + '\'' +
                ", createTs=" + createTs +
                ", updateTs=" + updateTs +
                '}';
    }
}
