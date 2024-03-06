package com.cu.unittest.user;

import com.cu.unittest.util.EmailService;

import java.util.List;

public class SendSalary {
    private EmailService emailService;
    private EmployeeRepository employeeRepository;

    public SendSalary(EmailService emailService, EmployeeRepository employeeRepository) {
        this.emailService = emailService;
        this.employeeRepository = employeeRepository;
    }

    public Double totalSalaryNeedToPay(){
        List<Employee> allEmployee = employeeRepository.findAllEmployee();
        return allEmployee.stream().mapToDouble(Employee::getSalary).sum();
    }
}
