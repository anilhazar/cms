package com.anil.vtys.cms.service.employee.impl;

import com.anil.vtys.cms.model.entity.EmployeeEntity;
import com.anil.vtys.cms.repository.EmployeeRepository;
import com.anil.vtys.cms.service.employee.EmployeeDeleteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeDeleteServiceImpl implements EmployeeDeleteService {

    private final EmployeeRepository employeeRepository;

    @Override
    public String deleteEmployeeById(
            final Long employeeId
    ) {
        final EmployeeEntity employeeEntityToBeDelete = employeeRepository
                .findById(employeeId)
                .orElseThrow(()->new RuntimeException("ID Değeri belirtilen EmployeeEntity bulunamadı"));

        employeeRepository.delete(employeeEntityToBeDelete);

        return employeeId + " ID Numaralı EmployeeEntity Başarılı Bir Şekilde Silindi.";
    }
}
