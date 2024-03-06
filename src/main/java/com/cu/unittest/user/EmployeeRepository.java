package com.cu.unittest.user;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository  {
    public void saveEmployee(Employee employee);
    public List<Employee> findAllEmployee();

    Optional<Employee> findById(Integer id);
}
