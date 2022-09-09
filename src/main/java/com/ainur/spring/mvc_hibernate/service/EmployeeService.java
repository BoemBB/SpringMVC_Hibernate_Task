package com.ainur.spring.mvc_hibernate.service;

import com.ainur.spring.mvc_hibernate.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees();

    void saveEmployee(Employee employee);

    Employee getEmployee(int id);

    void deleteEmployee(int id);

    List<Employee> groupEmployeesByName();

    public List getEmployeesWithPosition();
}
