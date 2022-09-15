package com.example.SpringSecurity.Service;

import com.example.SpringSecurity.Entity.Employee;
import com.example.SpringSecurity.Entity.SuccessResponse;
import com.example.SpringSecurity.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }

//    public Object findById(Long Id)
//    {
//        Optional<Employee> employee = employeeRepository.findById(Id);
//        return new SuccessResponse(
//                "200", "Got Employee", true, employee, "eiks"
//        );
//    }
}
