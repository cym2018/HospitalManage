package org.example.common;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

/**
 * @description 表的公共属性
 */

@MappedSuperclass
public abstract class CommonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;
    @Column
    protected Integer state;
    @Column
    protected String note;
    @CreationTimestamp
    protected Date createTs;
    @UpdateTimestamp
    protected Date updateTs;

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateTs() {
        return createTs;
    }

    public Date getUpdateTs() {
        return updateTs;
    }
}
