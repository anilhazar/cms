package com.anil.vtys.cms.service.branch.impl;

import com.anil.vtys.cms.model.entity.BranchEntity;
import com.anil.vtys.cms.repository.BranchRepository;
import com.anil.vtys.cms.service.branch.BranchDeleteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BranchDeleteServiceImpl implements BranchDeleteService {

    private final BranchRepository branchRepository;

    @Override
    public String deleteBranchById(
           final Long branchId
    ) {
        final BranchEntity branchEntityToBeDelete = branchRepository
                .findById(branchId)
                .orElseThrow(()->new RuntimeException("ID Değeri Belirtilen BranchEntity Bulunamadı"));

        branchRepository.delete(branchEntityToBeDelete);

        return branchId + " ID değerine sahip BranchEntity Başarıyla Silindi.";
    }
}
