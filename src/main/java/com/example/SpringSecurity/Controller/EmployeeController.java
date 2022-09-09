package com.example.SpringSecurity.Controller;

import com.example.SpringSecurity.Entity.Employee;
import com.example.SpringSecurity.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;
    @PostMapping("/employees/add")
    public String addEmployee(@ModelAttribute Employee employee)
    {
        employeeRepository.save(employee);
        return "Done";
    }
}
