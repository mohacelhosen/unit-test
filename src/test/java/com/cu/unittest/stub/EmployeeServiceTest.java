package com.cu.unittest.stub;

import com.cu.unittest.user.Employee;
import com.cu.unittest.user.EmployeeRepository;
import com.cu.unittest.user.EmployeeService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeServiceTest {
    @Test
    public void testSalaryIncrease(){
        EmployeeRepository employeeRepository = new EmployeeRepositoryStub();
        EmployeeService employeeService = new EmployeeService(employeeRepository);
        List<Employee> salaryIncrease = employeeService.salaryIncrease(2.6);
        assertEquals(4, salaryIncrease.size());
        assertEquals(33000, salaryIncrease.get(0).getSalary());
        assertEquals(35000, salaryIncrease.get(1).getSalary());
        assertEquals(34000, salaryIncrease.get(2).getSalary());
        assertEquals(32000, salaryIncrease.get(3).getSalary());
    }

}
