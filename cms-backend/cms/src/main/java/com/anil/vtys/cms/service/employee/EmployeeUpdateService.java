package com.anil.vtys.cms.service.employee;

import com.anil.vtys.cms.model.Employee;
import com.anil.vtys.cms.model.dto.employee.request.EmployeeUpdateRequest;
import com.anil.vtys.cms.model.entity.EmployeeEntity;

public interface EmployeeUpdateService {
    Employee updateEmployeeById(
            final Long employeeId,
            final EmployeeUpdateRequest employeeUpdateRequest
    );

    void detachBranchOfEmployeeById(
            final Long employeeId
    );

    void changeBranchByEmployeeIdAndBranchId(
            final Long employeeId,
            final Long branchId
    );
}
