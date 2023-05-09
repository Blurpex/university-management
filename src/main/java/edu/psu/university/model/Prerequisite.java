package edu.psu.university.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="prerequisite")
public class Prerequisite {

    @Id
    @Column(name="course_id")
    private String courseId;

    @Id
    @Column(name="prerequisite_id")
    private String prerequisiteId;

    public Prerequisite() {}

    public Prerequisite(String courseId, String prerequisiteId) {
        this.courseId = courseId;
        this.prerequisiteId = prerequisiteId;
    }
}
