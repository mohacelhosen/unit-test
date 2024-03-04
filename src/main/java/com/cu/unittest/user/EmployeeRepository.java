package com.cu.unittest.user;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository  {
    public void saveEmployee(Employee employee);
    public List<Employee> findAllEmployee();

}
