package com.ainur.spring.mvc_hibernate.service;

import com.ainur.spring.mvc_hibernate.dao.EmployeeDAO;
import com.ainur.spring.mvc_hibernate.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@EnableTransactionManagement
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    @Transactional
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    @Override
    @Transactional
    public void saveEmployee(Employee employee) {
        employeeDAO.saveEmployee(employee);
    }

    @Override
    @Transactional
    public Employee getEmployee(int id) {
        return employeeDAO.getEmployee(id);
    }

    @Override
    @Transactional
    public void deleteEmployee(int id) {
        employeeDAO.deleteEmployee(id);
    }

    @Override
    @Transactional
    public List<Employee> groupEmployeesByName() {
        return employeeDAO.groupEmployeesByName();
    }

    @Override
    @Transactional
    public List getEmployeesWithPosition() {
        return employeeDAO.getEmployeesWithPosition();
    }

}
