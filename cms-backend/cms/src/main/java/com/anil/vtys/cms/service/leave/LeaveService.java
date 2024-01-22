package com.anil.vtys.cms.service.leave;

import com.anil.vtys.cms.model.Employee;
import com.anil.vtys.cms.model.Leave;

import java.util.List;

public interface LeaveService {
    List<Leave> getAllLeavesFromEmployee(
            final Employee employee
    );
}
