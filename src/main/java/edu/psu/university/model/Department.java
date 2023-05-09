package edu.psu.university.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="department")
public class Department {

    @Id
    @Column(name="dept_name")
    private String deptName;

    @Column(name="building")
    private String building;

    @Column(name="budget")
    private double budget;

    public Department() {}

    public Department(String deptName, String building, double budget) {
        this.deptName = deptName;
        this.building = building;
        this.budget = budget;
    }
}
