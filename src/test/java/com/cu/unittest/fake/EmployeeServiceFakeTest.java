package com.cu.unittest.fake;

import com.cu.unittest.user.Employee;
import com.cu.unittest.user.EmployeeRepository;
import com.cu.unittest.user.EmployeeService;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class EmployeeServiceFakeTest {

    @Test
    public void fakeTestDoubleUsingMockito() {
        // Create a mock for EmployeeRepository
        EmployeeRepository repository = mock(EmployeeRepository.class);

        // Create an EmployeeService instance with the mock repository
        EmployeeService service = new EmployeeService(repository);

        List<Employee> employeeList = new ArrayList<>();

        // Create an Employee instance for testing
        Employee testEmployee = new Employee(1001, "Mohacel", "male", 23, "Backend Developer", 2.6, 28000);

        // Define behavior for saveEmployee method on the mock repository
        doAnswer(invocation -> {
            Employee employee = invocation.getArgument(0);
            employeeList.add(employee);
            return null; // The return type of saveEmployee is void
        }).when(repository).saveEmployee(any(Employee.class));


        // Call the saveEmployee method on the EmployeeService
        service.saveEmployee(testEmployee);

        when(repository.findAllEmployee()).thenReturn(employeeList);

        // Optionally, assert other things about the service.getAll() result
        assertEquals(1, service.getAll().size()); // Issue is here
    }
}
