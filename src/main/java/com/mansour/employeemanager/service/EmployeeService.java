package com.mansour.employeemanager.service;


import com.mansour.employeemanager.exception.EmployeeException;
import com.mansour.employeemanager.model.Employee;
import com.mansour.employeemanager.repo.EmployeeRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;
    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo1) {
        this.employeeRepo = employeeRepo1;
    }

    public Employee addEmployee(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
       return  employeeRepo.save(employee);
    }

    public List<Employee> findAllEmployee() {
        return employeeRepo.findAll();
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    public Employee findEmployeeById(Long id) {
        return employeeRepo.findEmployeeById(id).orElseThrow(()-> new EmployeeException("employee by id: " + id + " was not found"));
    }
    @Transactional
    public void deleteEmployeeById(Long id) {
        employeeRepo.deleteEmployeeById(id);
    }


}
