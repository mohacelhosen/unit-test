package com.cu.unittest.spy;

import com.cu.unittest.user.Employee;
import com.cu.unittest.user.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeServiceSpyTest {

    EmployeeRepositorySpy employeeRepositorySpy = new EmployeeRepositorySpy();
    EmployeeService employeeService = new EmployeeService(employeeRepositorySpy);

    @BeforeEach
    void setUp() {
        employeeRepositorySpy.reset();
    }

    @Test
    public void testSalaryIncrease(){
       employeeService.saveEmployee(new Employee(1001, "Mohacel", "male", 23, "Backend Developer", 2.6, 28000));
       employeeService.saveEmployee(new Employee(1002, "Asadu", "male", 23, "Frontend Developer", 2.0, 28000));

        int added = employeeRepositorySpy.employeeList.size();
        assertEquals(2,added);
        assertEquals(2, employeeRepositorySpy.saveMethodCall);

        // Retrieve the last added employee
        Employee lastAddedEmployee = employeeRepositorySpy.lastAdded;

        // Assert specific values of the lastAdded employee
        assertEquals(1002, lastAddedEmployee.getId());
        assertEquals("Asadu", lastAddedEmployee.getName());
        assertEquals("male", lastAddedEmployee.getGender());
        assertEquals(23, lastAddedEmployee.getAge());
        assertEquals("Frontend Developer", lastAddedEmployee.getDepartment());
        assertEquals(2.0, lastAddedEmployee.getWorkExperience());
        assertEquals(28000, lastAddedEmployee.getSalary());
    }
}
