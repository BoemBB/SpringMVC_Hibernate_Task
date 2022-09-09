package com.ainur.spring.mvc_hibernate.controller;

import com.ainur.spring.mvc_hibernate.entity.Employee;
import com.ainur.spring.mvc_hibernate.service.EmployeeService;
import com.ainur.spring.mvc_hibernate.execption_handling.NoSuchEmployeeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showAllEmployees(){
        List<Employee> allEmployees = employeeService.getAllEmployees();

        return allEmployees;
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id){
        Employee employee = employeeService.getEmployee(id);

        if(employee == null){
            throw new NoSuchEmployeeException("there is no Employee with this id " + id);
        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id){
        Employee employee = employeeService.getEmployee(id);
        if (employee == null){
            throw new NoSuchEmployeeException("there is no employee with id " + id);
        }
        employeeService.deleteEmployee(id);
        return "Employee " + id + " was deleted";
    }

    //Запрос c группировкой
    @GetMapping("/employees/group")
    public List<Employee> groupEmployee(){
        return employeeService.groupEmployeesByName();
    }

    //Запрос по нескольким таблицам
    @GetMapping("/employees/position")
    public List<?> getEmployeePosition(){
        return employeeService.getEmployeesWithPosition();
    }

}
