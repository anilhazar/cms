package com.anil.vtys.cms.service;

import com.anil.vtys.cms.repository.EmployeeRepository;

public class EmployeeServiceImply implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImply(EmployeeRepository employeeRepository){
        this.employeeRepository=employeeRepository;
    }
}
