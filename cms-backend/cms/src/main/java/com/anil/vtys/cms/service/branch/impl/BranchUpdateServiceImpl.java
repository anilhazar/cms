package com.anil.vtys.cms.service.branch.impl;

import com.anil.vtys.cms.model.Branch;
import com.anil.vtys.cms.model.dto.branches.request.BranchUpdateRequest;
import com.anil.vtys.cms.model.entity.BranchEntity;
import com.anil.vtys.cms.model.mapper.branch.BranchMapper;
import com.anil.vtys.cms.repository.BranchRepository;
import com.anil.vtys.cms.service.branch.BranchUpdateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BranchUpdateServiceImpl implements BranchUpdateService {
    private final BranchRepository branchRepository;

    @Override
    public Branch updateBranchById(
            final Long branchId,
            final BranchUpdateRequest branchUpdateRequest
    ) {
        final BranchEntity branchEntityToBeUpdated = branchRepository
                .findById(branchId)
                .orElseThrow(() -> new RuntimeException("ID Değeri Belirtilen BranchEntity Bulunamadı"));

        branchEntityToBeUpdated.setName(branchUpdateRequest.getName());

        branchRepository.save(branchEntityToBeUpdated);

        return BranchMapper.toDomainModel(branchEntityToBeUpdated);
    }
}
