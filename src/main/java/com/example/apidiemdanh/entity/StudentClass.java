package com.example.apidiemdanh.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "student_class")
public class StudentClass {
    private Long studentClassId;
    private Long studentId;
    private Long classId;

    @Basic
    @Column(name = "student_class_ic", nullable = true)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getStudentClassId() {
        return studentClassId;
    }

    public void setStudentClassId(Long studentClassId) {
        this.studentClassId = studentClassId;
    }

    @Basic
    @Column(name = "student_id", nullable = true)
    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    @Basic
    @Column(name = "class_id", nullable = true)
    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentClass that = (StudentClass) o;
        return Objects.equals(studentClassId, that.studentClassId) &&
                Objects.equals(studentId, that.studentId) &&
                Objects.equals(classId, that.classId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentClassId, studentId, classId);
    }
}
