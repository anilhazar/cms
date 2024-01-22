package com.anil.vtys.cms.service.branch;

import com.anil.vtys.cms.model.Branch;
import com.anil.vtys.cms.model.dto.branches.request.BranchUpdateRequest;

public interface BranchUpdateService {
    Branch updateBranchById(
            final Long branchId,
            final BranchUpdateRequest branchUpdateRequest
    );
}
