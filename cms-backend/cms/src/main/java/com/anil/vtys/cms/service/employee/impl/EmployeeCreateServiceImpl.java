package com.anil.vtys.cms.service.employee.impl;

import com.anil.vtys.cms.model.Branch;
import com.anil.vtys.cms.model.Employee;
import com.anil.vtys.cms.model.dto.employee.request.EmployeeCreateRequest;
import com.anil.vtys.cms.model.entity.EmployeeEntity;
import com.anil.vtys.cms.model.mapper.branch.BranchMapper;
import com.anil.vtys.cms.model.mapper.employee.EmployeeMapper;
import com.anil.vtys.cms.repository.EmployeeRepository;
import com.anil.vtys.cms.service.branch.BranchService;
import com.anil.vtys.cms.service.employee.EmployeeCreateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class EmployeeCreateServiceImpl implements EmployeeCreateService {

    private final EmployeeRepository employeeRepository;
    private final BranchService branchService;



    @Override
    public Employee createEmployee(
            final EmployeeCreateRequest employeeCreateRequest
    ) {
        final EmployeeEntity employeeEntityToBeSave = EmployeeEntity.builder()
                .firstName(employeeCreateRequest.getFirstName())
                .lastName(employeeCreateRequest.getLastName())
                .age(employeeCreateRequest.getAge())
                .gender(employeeCreateRequest.getGender())
                .birthDate(employeeCreateRequest.getBirthDate())
                .build();

        this.findAndSetBranch(
                employeeCreateRequest,
                employeeEntityToBeSave
        );

        employeeRepository.save(employeeEntityToBeSave);

        return EmployeeMapper.toDomainModel(employeeEntityToBeSave);
    }

    /**
     * Eğer EmployeeEntity oluşturmak için kullanılan EmployeeCreateRequest nesnesi içerisinde
     * branchID alanı null değilse, yani belirtilmiş ise, ilgili BranchEntity'i bulup EmployeeEntity ile ilişkilendirir.
     *
     * @param employeeCreateRequest
     * @param employeeEntityToBeSave
     */
    private void findAndSetBranch(
            final EmployeeCreateRequest employeeCreateRequest,
            final EmployeeEntity employeeEntityToBeSave
    ) {
        if (Objects.nonNull(employeeCreateRequest.getBranchId())) {
            final Branch branch = branchService
                    .getBranchById(employeeCreateRequest.getBranchId());

            employeeEntityToBeSave.setBranchEntity(
                    BranchMapper.toEntity(branch)
            );
        }
    }
}
