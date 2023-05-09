package edu.psu.university.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="advisor")
public class Advisor {

    @Id
    @Column(name="student_id")
    private int studentId;

    @Id
    @Column(name="instructor_id")
    private int instructorId;

    public Advisor() {}

    public Advisor(int studentId, int instructorId) {
        this.studentId = studentId;
        this.instructorId = instructorId;
    }
}
