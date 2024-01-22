package com.anil.vtys.cms.service.branch;

import com.anil.vtys.cms.model.Branch;

import java.util.List;

public interface BranchService {
    Branch getBranchById(
            final Long branchId
    );

    List<Branch> getAllBranches();
}
