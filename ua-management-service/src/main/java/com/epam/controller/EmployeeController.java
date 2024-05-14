package com.epam.controller;

import com.epam.model.Employee;
import com.epam.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/all")
    public List<Employee> getAllEmployees(){
        return employeeService.findAllEmployees();
    }

    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }
}
