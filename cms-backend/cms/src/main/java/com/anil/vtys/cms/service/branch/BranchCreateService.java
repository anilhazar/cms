package com.anil.vtys.cms.service.branch;

import com.anil.vtys.cms.model.Branch;
import com.anil.vtys.cms.model.dto.branches.request.BranchCreateRequest;

public interface BranchCreateService {
    Branch createBranch(
            final BranchCreateRequest branchCreateRequest
    );
}
