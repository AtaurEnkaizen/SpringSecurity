package com.example.SpringSecurity.Controller;

import com.example.SpringSecurity.Entity.Employee;
import com.example.SpringSecurity.Repository.EmployeeRepository;
import com.example.SpringSecurity.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    /*@PostMapping("/employees/add")
    public String addEmployee(@ModelAttribute Employee employee)
    {
        employeeService.save(employee);
        return "Done";
    }*/

//    @GetMapping("/find")
//    public Object findById(@RequestParam("id") Long id)
//    {
//        return employeeService.findById(id);
//    }
    @GetMapping("/all")
    public List<Employee> getAllEmployee()
    {
        return employeeService.getAllEmployee();
    }
}
