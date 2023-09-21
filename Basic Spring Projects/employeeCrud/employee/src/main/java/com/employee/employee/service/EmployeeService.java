package com.employee.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.employee.dom.Employee;
import com.employee.employee.repository.EmployeeRepository;

@Service
public class EmployeeService {
    
    @Autowired
    private EmployeeRepository repo;
    
    public List<Employee> listAll() {
        return repo.findAll();
    }
     
    public void save(Employee emp) {
        repo.save(emp);
    }
     
    public Employee get(long id) {
        return repo.findById(id).get();
    }
     
    public void delete(long id) {
        repo.deleteById(id);
    }

}