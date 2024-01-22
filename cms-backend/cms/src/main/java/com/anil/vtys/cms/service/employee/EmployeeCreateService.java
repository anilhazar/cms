package com.anil.vtys.cms.service.employee;

import com.anil.vtys.cms.model.Employee;
import com.anil.vtys.cms.model.dto.employee.request.EmployeeCreateRequest;
import com.anil.vtys.cms.model.entity.EmployeeEntity;

public interface EmployeeCreateService {
    Employee createEmployee(
            final EmployeeCreateRequest employeeCreateRequest
    );
}
