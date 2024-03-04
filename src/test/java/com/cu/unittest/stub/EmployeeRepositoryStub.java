package com.cu.unittest.stub;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryStub implements EmployeeRepository {

    @Override
    public void saveEmployee(Employee employee) {

    }

    @Override
    public List<Employee> findAllEmployee() {
        List<Employee> employeeList = new ArrayList<>();
        // Create 10 employee instances for testing using new keyword
        employeeList.add(new Employee(1001, "Mohacel", "male", 23, "Backend Developer", 2.6, 28000));
        employeeList.add(new Employee(1002, "John", "male", 30, "Frontend Developer", 3.0, 30000));
        employeeList.add(new Employee(1003, "Alice", "female", 28, "QA Engineer", 2.5, 28000));
        employeeList.add(new Employee(1004, "Bob", "male", 25, "Product Manager", 2.0, 35000));
        employeeList.add(new Employee(1005, "Emily", "female", 27, "Backend Developer", 2.5, 26000));
        employeeList.add(new Employee(1006, "Charlie", "male", 26, "Frontend Developer", 2.0, 31000));
        employeeList.add(new Employee(1007, "Eva", "female", 29, "QA Engineer", 3.0, 29000));
        employeeList.add(new Employee(1008, "David", "male", 24, "Product Manager", 2.5, 36000));
        employeeList.add(new Employee(1009, "Sophia", "female", 31, "Backend Developer", 3.0, 27000));
        employeeList.add(new Employee(1010, "Alex", "male", 28, "Frontend Developer", 2.5, 32000));

        return employeeList;
    }
}
