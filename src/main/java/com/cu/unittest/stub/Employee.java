package com.cu.unittest.stub;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private Integer id;
    private String name;
    private String gender;
    private Integer age;
    private String department;
    private Double workExperience;
    private Integer salary;

    public Employee(Employee employee) {
        this.id = employee.id;
        this.name = employee.name;
        this.gender = employee.gender;
        this.age = employee.age;
        this.department = employee.department;
        this.workExperience = employee.workExperience;
        this.salary = employee.salary;
    }
}

