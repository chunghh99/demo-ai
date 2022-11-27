package com.example.apidiemdanh.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "attendance")
public class Attendance {
    private Long attendanceId;
    private Long studentId;
    private Date time;
    private String location;

    @Id
    @Column(name = "attendance_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(Long attendanceId) {
        this.attendanceId = attendanceId;
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
    @Column(name = "time", nullable = true)
    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Basic
    @Column(name = "location", nullable = true, length = 500)
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Attendance that = (Attendance) o;
        return attendanceId == that.attendanceId &&
                Objects.equals(studentId, that.studentId) &&
                Objects.equals(time, that.time) &&
                Objects.equals(location, that.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(attendanceId, studentId, time, location);
    }
}
