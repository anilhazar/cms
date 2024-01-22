package com.anil.vtys.cms.service.leave;

import com.anil.vtys.cms.model.Employee;
import com.anil.vtys.cms.model.Leave;
import com.anil.vtys.cms.model.dto.leave.request.LeaveCreateRequest;

public interface LeaveCreateService {
    Leave createLeaveForEmployee(
            final Employee employee,
            final LeaveCreateRequest leaveCreateRequest
    );
}
