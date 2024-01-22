package com.anil.vtys.cms.service.employee;

import com.anil.vtys.cms.model.Employee;
import com.anil.vtys.cms.model.aggregate.EmployeeAggregateWithBranch;
import com.anil.vtys.cms.model.entity.EmployeeEntity;

import java.util.List;

public interface EmployeeService {
    Employee getEmployeeById(
            final Long employeeId
    );

    EmployeeAggregateWithBranch getEmployeeByIdAggregateWithBranch(
            final Long employeeId
    );

    List<Employee> getAllEmployees();

    List<EmployeeAggregateWithBranch> getAllEmployeesWithBranch();
}
