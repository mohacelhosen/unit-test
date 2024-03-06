package com.cu.unittest.user;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public void saveEmployee(Employee employee) {
        repository.saveEmployee(employee);
    }

    public List<Employee> salaryIncrease(Double experience) {
        List<Employee> employeeList = repository.findAllEmployee();
        return employeeList.stream().filter(employee -> employee.getWorkExperience() >= experience).map(employee -> {
            Employee updatedEmployee = new Employee(employee.getId(), employee.getName(), employee.getGender(), employee.getAge(), employee.getDepartment(), employee.getWorkExperience(), employee.getSalary());
            updatedEmployee.setSalary(employee.getSalary() + 5000);
            return updatedEmployee;
        }).toList();
    }

    public List<Employee> getAll() {
        return repository.findAllEmployee();
    }

    public Employee updateEmployeeInfo(Employee employee) {
        if (employee.getId() == null || employee.getId() == 0) {
            throw new IdNotFoundException("Id can't be null or Zero");
        }

        Employee dbEmployee = repository.findById(employee.getId()).orElseThrow(() -> new ResourceNotFoundException("Employee not found with id - " + employee.getId()));

        BeanUtils.copyProperties(employee, dbEmployee);
        repository.saveEmployee(dbEmployee);
        return dbEmployee;
    }

}
