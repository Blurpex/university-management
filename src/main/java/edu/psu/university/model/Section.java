package edu.psu.university.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="section")
public class Section {

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

    @Column(name="building")
    private String building;

    @Column(name="room_number")
    private String roomNumber;

    @Column(name="time_slot_id")
    private String timeSlotId;

    public Section() {}

    public Section(String courseId, int sectionId, String semester, int year, String building, String roomNumber, String timeSlotId) {
        this.courseId = courseId;
        this.sectionId = sectionId;
        this.semester = semester;
        this.year = year;
        this.building = building;
        this.roomNumber = roomNumber;
        this.timeSlotId = timeSlotId;
    }
}
