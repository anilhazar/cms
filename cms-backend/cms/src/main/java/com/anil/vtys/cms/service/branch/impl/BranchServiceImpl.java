package com.anil.vtys.cms.service.branch.impl;

import com.anil.vtys.cms.model.Branch;
import com.anil.vtys.cms.model.entity.BranchEntity;
import com.anil.vtys.cms.model.mapper.branch.BranchMapper;
import com.anil.vtys.cms.repository.BranchRepository;
import com.anil.vtys.cms.service.branch.BranchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BranchServiceImpl implements BranchService {

    private final BranchRepository branchRepository;

    @Override
    public Branch getBranchById(
            final Long branchId
    ) {
        final BranchEntity branchEntity = branchRepository
                .findById(branchId)
                .orElseThrow(()->new RuntimeException("ID değeri verilen BranchEntity bulunamadı."));

        return BranchMapper.toDomainModel(branchEntity);
    }

    @Override
    public List<Branch> getAllBranches() {
        final List<BranchEntity> branchEntities = branchRepository
                .findAll();

        return BranchMapper.toDomainModel(branchEntities);
    }
}
