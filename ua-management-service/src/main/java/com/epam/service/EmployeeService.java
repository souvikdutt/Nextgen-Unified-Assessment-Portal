package com.epam.service;

import com.epam.model.Employee;
import com.epam.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> findAllEmployees(){
        return employeeRepository.findAll();
    }

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
}
