package com.example.apidiemdanh.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "teacher")
public class Teacher {
    private long teacherId;
    private String phone;
    private String fullName;
    private String address;
    private Date birthday;

    @Id
    @Column(name = "teacher_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(long teacherId) {
        this.teacherId = teacherId;
    }

    @Basic
    @Column(name = "phone", nullable = false, length = 50)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "full_name", nullable = true, length = 50)
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Basic
    @Column(name = "address", nullable = true, length = 500)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "birthday", nullable = true)
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return teacherId == teacher.teacherId &&
                Objects.equals(phone, teacher.phone) &&
                Objects.equals(fullName, teacher.fullName) &&
                Objects.equals(address, teacher.address) &&
                Objects.equals(birthday, teacher.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teacherId, phone, fullName, address, birthday);
    }
}
