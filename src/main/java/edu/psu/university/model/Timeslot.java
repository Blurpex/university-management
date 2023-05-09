package edu.psu.university.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Entity
@Table(name="timeslot")
public class Timeslot {

    @Id
    @Column(name="time_slot_id")
    private String timeSlotId;

    @Id
    @Column(name="day")
    private String day;

    @Id
    @Column(name="start_time")
    private Timestamp startTime;

    @Column(name="end_time")
    private Timestamp endTime;

    public Timeslot() {}

    public Timeslot(String timeSlotId, String day, Timestamp startTime, Timestamp endTime) {
        this.timeSlotId = timeSlotId;
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
