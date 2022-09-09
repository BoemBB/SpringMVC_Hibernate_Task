package com.ainur.spring.mvc_hibernate.controller;

import com.ainur.spring.mvc_hibernate.entity.Customer;
import com.ainur.spring.mvc_hibernate.execption_handling.NoSuchEmployeeException;
import com.ainur.spring.mvc_hibernate.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public List<Customer> showAllCustomers(){
        List<Customer> allCustomers = customerService.getAllCustomers();

        return allCustomers;
    }

    @GetMapping("/customers/{id}")
    public Customer getCustomer(@PathVariable int id){
        Customer customer = customerService.getCustomer(id);

        if(customer == null){
            throw new NoSuchEmployeeException("there is no Customer with this id " + id);
        }
        return customer;
    }

    @PostMapping("/customers")
    public Customer addNewCustomer(@RequestBody Customer customer){
        customerService.saveCustomer(customer);
        return customer;
    }

    @PutMapping("/customers")
    public Customer updateCustomer(@RequestBody Customer customer){
        customerService.saveCustomer(customer);
        return customer;
    }

    @DeleteMapping("/customers/{id}")
    public String deleteCustomer(@PathVariable int id){
        Customer customer = customerService.getCustomer(id);
        if (customer == null){
            throw new NoSuchEmployeeException("there is no Customer with id " + id);
        }
        customerService.deleteCustomer(id);
        return "Customer " + id + "was deleted";
    }
}
