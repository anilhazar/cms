package com.anil.vtys.cms.service.leave;

import com.anil.vtys.cms.model.Leave;
import com.anil.vtys.cms.model.dto.leave.request.LeaveUpdateRequest;

public interface LeaveUpdateService {
    Leave updateLeaveById(
            final Long leaveId,
            final LeaveUpdateRequest leaveUpdateRequest
    );
}
