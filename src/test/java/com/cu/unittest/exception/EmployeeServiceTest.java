package com.cu.unittest.exception;

import com.cu.unittest.user.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

    @InjectMocks
    private EmployeeService service;

    @Mock
    private EmployeeRepository repository;

    @Test
    public void testUpdateEmployeeInfoWithNullId() {
        try {
            service.updateEmployeeInfo(new Employee(null, "Mohacel", "male", 23, "Backend Developer", 2.6, 28000));
        } catch (IdNotFoundException e) {
            assertEquals("Id can't be null or Zero", e.getMessage());
        }
    }

    @Test
    public void testUpdateEmployeeInfoWithZeroId() {
        try {
            service.updateEmployeeInfo(new Employee(0, "Mohacel", "Male", 22, "Full-Stack Java Developer", 2.5, 2500));
        } catch (IdNotFoundException e) {
            assertEquals("Id can't be null or Zero", e.getMessage());
        }
    }


    @Test
    public void testUpdateEmployeeInfoWithNonExistentId() {
        try {
            service.updateEmployeeInfo(new Employee(1002, "Mohacel", "male", 23, "Backend Developer", 2.6, 28000));
        } catch (ResourceNotFoundException e) {
            verify(repository).findById(1002);
            assertEquals("Employee not found with id - 1002", e.getMessage());
        }
    }

    @Test
    public void testUpdateExistingEmployee() {
        // Create a sample existing employee
        Employee existingEmployee = new Employee(1001, "Mohacel", "male", 23, "Backend Developer", 2.6, 28000);

        // Mock the behavior of repository.findById to return the existing employee
        lenient().when(repository.findById(1001)).thenReturn(Optional.of(existingEmployee));

        // Call the method to update the employee information
        service.updateEmployeeInfo(new Employee(1001, "Mohacel Hosen", "male", 23, "Backend Developer", 2.6, 30000));

        // Capture the argument passed to saveEmployee
        ArgumentCaptor<Employee> employeeCaptor = ArgumentCaptor.forClass(Employee.class);
        verify(repository, times(1)).saveEmployee(employeeCaptor.capture());

        // Assert the captured employee has the expected changes
        Employee updatedEmployee = employeeCaptor.getValue();
        assertEquals("Mohacel Hosen", updatedEmployee.getName());
        assertEquals(30000, updatedEmployee.getSalary());
    }
}
