package edu.psu.university.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="classroom")
public class Classroom {

    @Id
    @Column(name="building")
    private String building;

    @Id
    @Column(name="room_number")
    private String roomNumber;

    @Column(name="capacity")
    private int capacity;

    public Classroom() {}

    public Classroom(String building, String roomNumber, int capacity) {
        this.building = building;
        this.roomNumber = roomNumber;
        this.capacity = capacity;
    }
}
