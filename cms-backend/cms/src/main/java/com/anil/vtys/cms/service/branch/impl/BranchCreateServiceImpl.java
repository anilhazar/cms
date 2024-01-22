package com.anil.vtys.cms.service.branch.impl;

import com.anil.vtys.cms.model.Branch;
import com.anil.vtys.cms.model.dto.branches.request.BranchCreateRequest;
import com.anil.vtys.cms.model.entity.BranchEntity;
import com.anil.vtys.cms.model.mapper.branch.BranchMapper;
import com.anil.vtys.cms.repository.BranchRepository;
import com.anil.vtys.cms.service.branch.BranchCreateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BranchCreateServiceImpl implements BranchCreateService {

    private final BranchRepository branchRepository;

    @Override
    public Branch createBranch(
            final BranchCreateRequest branchCreateRequest
    ) {
        final BranchEntity branchEntityToBeSave = BranchEntity.builder()
                .name(branchCreateRequest.getName())
                .build();

        branchRepository.save(branchEntityToBeSave);

        return BranchMapper.toDomainModel(branchEntityToBeSave);
    }
}
