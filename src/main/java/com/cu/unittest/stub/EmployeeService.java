package com.cu.unittest.stub;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private EmployeeRepository repository;
    public EmployeeService(EmployeeRepository repository){
        this.repository=repository;
    }

    public void saveEmployee(Employee employee){
        repository.saveEmployee(employee);
    }

    public List<Employee> salaryIncrease(Double experience){
        List<Employee> employeeList = repository.findAllEmployee();
        return employeeList.stream().filter(employee -> employee.getWorkExperience() >= experience).map(employee -> {
            Employee updatedEmployee = new Employee(employee.getId(), employee.getName(), employee.getGender(), employee.getAge(), employee.getDepartment(), employee.getWorkExperience(), employee.getSalary());
            updatedEmployee.setSalary(employee.getSalary() + 5000);
            return updatedEmployee;
        }).toList();
    }
}
