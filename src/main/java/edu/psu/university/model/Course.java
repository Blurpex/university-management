package edu.psu.university.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="course")
public class Course {

    @Id
    @Column(name="course_id")
    private String courseId;

    @Column(name="title")
    private String courseTitle;

    @Column(name="dept_name")
    private String deptName;

    @Column(name="credits")
    private int credits;

    public Course() {}

    public Course(String courseId, String courseTitle, String deptName, int credits) {
        this.courseId = courseId;
        this.courseTitle = courseTitle;
        this.deptName = deptName;
        this.credits = credits;
    }
}
