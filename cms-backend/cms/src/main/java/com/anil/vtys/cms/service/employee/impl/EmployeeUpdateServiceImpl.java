package com.anil.vtys.cms.service.employee.impl;

import com.anil.vtys.cms.model.Branch;
import com.anil.vtys.cms.model.Employee;
import com.anil.vtys.cms.model.dto.employee.request.EmployeeUpdateRequest;
import com.anil.vtys.cms.model.entity.EmployeeEntity;
import com.anil.vtys.cms.model.mapper.branch.BranchMapper;
import com.anil.vtys.cms.model.mapper.employee.EmployeeMapper;
import com.anil.vtys.cms.repository.EmployeeRepository;
import com.anil.vtys.cms.service.branch.BranchService;
import com.anil.vtys.cms.service.employee.EmployeeUpdateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeUpdateServiceImpl implements EmployeeUpdateService {

    private final EmployeeRepository employeeRepository;
    private final BranchService branchService;

    @Override
    public Employee updateEmployeeById(
            final Long employeeId,
            final EmployeeUpdateRequest employeeUpdateRequest
    ) {
        final EmployeeEntity employeeEntityToBeUpdate = employeeRepository
                .findById(employeeId)
                .orElseThrow(() -> new RuntimeException("ID Değeri belirtilen Employee bulunamadı."));

        employeeEntityToBeUpdate.setFirstName(employeeUpdateRequest.getFirstName());
        employeeEntityToBeUpdate.setLastName(employeeUpdateRequest.getLastName());
        employeeEntityToBeUpdate.setAge(employeeUpdateRequest.getAge());
        employeeEntityToBeUpdate.setGender(employeeUpdateRequest.getGender());
        employeeEntityToBeUpdate.setBirthDate(employeeUpdateRequest.getBirthDate());

        employeeRepository.save(employeeEntityToBeUpdate);

        return EmployeeMapper.toDomainModel(employeeEntityToBeUpdate);
    }

    @Override
    public void detachBranchOfEmployeeById(
            final Long employeeId
    ) {
        final EmployeeEntity employeeEntityFromDb = employeeRepository
                .findById(employeeId)
                .orElseThrow(() -> new RuntimeException("ID Değeri belirtilen Employee bulunamadı."));

        employeeEntityFromDb.setBranchEntity(null);

        employeeRepository.save(employeeEntityFromDb);
    }

    @Override
    public void changeBranchByEmployeeIdAndBranchId(
            final Long employeeId,
            final Long branchId
    ) {
        final EmployeeEntity employeeEntityFromDb = employeeRepository
                .findById(employeeId)
                .orElseThrow(() -> new RuntimeException("ID Değeri belirtilen Employee bulunamadı."));

        final Branch branch = branchService.getBranchById(branchId);

        employeeEntityFromDb.setBranchEntity(
                BranchMapper.toEntity(branch)
        );

        employeeRepository.save(employeeEntityFromDb);
    }
}
