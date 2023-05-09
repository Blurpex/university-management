package edu.psu.university.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="instructor")
public class Instructor {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int instructorId;

    @Column(name="name")
    private String instructorName;

    @Column(name="dept_name")
    private String deptName;

    @Column(name="salary")
    private double salary;

    public Instructor() {}

    public Instructor(int instructorId, String instructorName, String deptName, double salary) {
        this.instructorId = instructorId;
        this.instructorName = instructorName;
        this.deptName = deptName;
        this.salary = salary;
    }
}
