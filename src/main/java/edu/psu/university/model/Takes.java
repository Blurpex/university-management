package edu.psu.university.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="takes")
public class Takes {

    @Id
    @Column(name="id")
    private int studentId;

    @Id
    @Column(name="course_id")
    private String courseId;

    @Id
    @Column(name="sec_id")
    private int sectionId;

    @Id
    @Column(name="semester")
    private String semester;

    @Id
    @Column(name="year")
    private int year;

    @Column(name="grade")
    private String grade;

    public Takes() {}

    public Takes(int studentId, String courseId, int sectionId, String semester, int year, String grade) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.sectionId = sectionId;
        this.semester = semester;
        this.year = year;
        this.grade = grade;
    }
}
