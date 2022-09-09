package com.ainur.spring.mvc_hibernate.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "position")
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "position")
    @JsonIgnore
    private List<Employee> employees;

    public Position() {
    }

    public Position(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployee() {
        return employees;
    }

    public void setEmployee(List<Employee> employees) {
        this.employees = employees;
    }

    public void addEmployeeToPosition(Employee employee){
        if (employees == null){
            employees = new ArrayList<>();
        }
        employees.add(employee);
        employee.setPosition(this);
    }
}
