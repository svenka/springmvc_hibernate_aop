package com.fyodork.spring.mvc_hibernate_aop.dao;
import com.fyodork.spring.mvc_hibernate_aop.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface EmployeeDAO {
    public List<Employee> getAllEmployees();

    public void saveEmployee(Employee employee);

    public Employee getEmployee(int id);
}
