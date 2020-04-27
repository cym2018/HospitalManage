package org.example.common;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
/**
 * @description 人员相关公共属性,姓名,性别,年龄,身份证号
 */
@MappedSuperclass
public abstract class PeopleEntity extends CommonEntity {
    @Column
    protected String gender;
    @Column
    protected String idNumber;
    @Column
    protected String name;
    @Column
    protected Integer age;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
