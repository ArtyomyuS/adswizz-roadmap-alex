package com.adswizz.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

/**
 * Created by alex on 4/28/15.
 */
@Entity
public class School implements Serializable{
    private Integer id;
    private String nameSchool;
    private Set<Student> studentSet;
    private Set<Teacher> teacherSet;

    public School(Integer id, String nameSchool) {
        this.id = id;
        this.nameSchool = nameSchool;
    }

    @Id
    @GeneratedValue
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameSchool() {
        return nameSchool;
    }

    public void setNameSchool(String nameSchool) {
        this.nameSchool = nameSchool;
    }

    @OneToMany(fetch= FetchType.LAZY, mappedBy = "schoolStudent")
    public Set<Student> getStudentSet() {
        return studentSet;
    }

    public void setStudentSet(Set<Student> studentSet) {
        this.studentSet = studentSet;
    }
    @OneToMany(fetch=FetchType.LAZY, mappedBy = "schoolTeacher")
    public Set<Teacher> getTeacherSet() {
        return teacherSet;
    }

    public void setTeacherSet(Set<Teacher> teacherSet) {
        this.teacherSet = teacherSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof School)) return false;
        School school = (School) o;
        return Objects.equals(getId(), school.getId()) &&
                Objects.equals(getNameSchool(), school.getNameSchool()) &&
                Objects.equals(getStudentSet(), school.getStudentSet()) &&
                Objects.equals(getTeacherSet(), school.getTeacherSet());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNameSchool(), getStudentSet(), getTeacherSet());
    }
}
