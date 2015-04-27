package com.adswizz.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * Created by alex on 4/28/15.
 */
@Entity
public class Teacher implements Serializable{
    private Integer id;
    private String nameTeacher;
    private School schoolTeacher;

    public Teacher(Integer id, String nameTeacher) {
        this.id = id;
        this.nameTeacher = nameTeacher;
    }

    @Id
    @GeneratedValue
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameTeacher() {
        return nameTeacher;
    }

    public void setNameTeacher(String nameTeacher) {
        this.nameTeacher = nameTeacher;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="teacherSet")
    public School getSchoolTeacher() {
        return schoolTeacher;
    }

    public void setSchoolTeacher(School schoolTeacher) {
        this.schoolTeacher = schoolTeacher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Teacher)) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(getId(), teacher.getId()) &&
                Objects.equals(getNameTeacher(), teacher.getNameTeacher()) &&
                Objects.equals(getSchoolTeacher(), teacher.getSchoolTeacher());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNameTeacher(), getSchoolTeacher());
    }
}
