package com.cu.unittest.test;

import com.cu.unittest.user.Employee;
import com.cu.unittest.user.EmployeeRepository;
import com.cu.unittest.user.EmployeeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

    @InjectMocks
    private EmployeeService service;

    @Mock
    private EmployeeRepository repository;

    @Test
    public void testSaveEmployee() {
        // Arrange
        Employee employee = new Employee(1001, "Mohacel", "male", 23, "Backend Developer", 2.6, 28000);
        ArgumentCaptor<Employee> employeeArgumentCaptor = ArgumentCaptor.forClass(Employee.class);
        doNothing().when(repository).saveEmployee(employeeArgumentCaptor.capture());

        // Act
        service.saveEmployee(employee);

        // Assert
        Employee capturedEmployee = employeeArgumentCaptor.getValue();
        assertEquals("Mohacel", capturedEmployee.getName());
        assertEquals("male", capturedEmployee.getGender());
        assertEquals(23, capturedEmployee.getAge());
    }
}
