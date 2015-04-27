package com.adswizz.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * Created by alex on 4/28/15.
 */
@Entity
public class Student implements Serializable{

    private Integer id;
    private String nameStudent;
    private School schoolStudent;

    public Student(Integer id, String nameStudent) {
        this.id = id;
        this.nameStudent = nameStudent;
    }

    @Id
    @GeneratedValue
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="studentSet")
    public School getSchoolStudent() {
        return schoolStudent;
    }

    public void setSchoolStudent(School schoolStudent) {
        this.schoolStudent = schoolStudent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return Objects.equals(getId(), student.getId()) &&
                Objects.equals(getNameStudent(), student.getNameStudent()) &&
                Objects.equals(getSchoolStudent(), student.getSchoolStudent());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNameStudent(), getSchoolStudent());
    }
}
