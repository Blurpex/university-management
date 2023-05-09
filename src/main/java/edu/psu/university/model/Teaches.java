package edu.psu.university.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="teaches")
public class Teaches {

    @Id
    @Column(name="id")
    private int instructorId;

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

    public Teaches() {}

    public Teaches(int instructorId, String courseId, int sectionId, String semester, int year) {
        this.instructorId = instructorId;
        this.courseId = courseId;
        this.sectionId = sectionId;
        this.semester = semester;
        this.year = year;
    }
}
