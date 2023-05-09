package edu.psu.university.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="student")
public class Student {

    @Id
    @Column(name="id")
    private int studentId;

    @Column(name="name")
    private String studentName;

    @Column(name="dept_name")
    private String deptName;

    @Column(name="total_cred")
    private int totalCredits;

    public Student() {}

    public Student(int studentId, String studentName, String deptName, int totalCredits) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.deptName = deptName;
        this.totalCredits = totalCredits;
    }
}
