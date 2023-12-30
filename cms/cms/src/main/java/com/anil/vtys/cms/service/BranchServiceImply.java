package com.anil.vtys.cms.service;

import com.anil.vtys.cms.repository.BranchRepository;

public class BranchServiceImply implements BranchService{
    private final BranchRepository branchRepository;


    public BranchServiceImply(BranchRepository branchRepository) {
        this.branchRepository=branchRepository;
    }

}
