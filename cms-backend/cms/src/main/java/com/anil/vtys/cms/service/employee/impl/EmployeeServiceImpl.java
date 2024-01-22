package com.anil.vtys.cms.service.employee.impl;

import com.anil.vtys.cms.model.Employee;
import com.anil.vtys.cms.model.aggregate.EmployeeAggregateWithBranch;
import com.anil.vtys.cms.model.entity.EmployeeEntity;
import com.anil.vtys.cms.model.mapper.employee.EmployeeMapper;
import com.anil.vtys.cms.repository.EmployeeRepository;
import com.anil.vtys.cms.service.employee.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;


    @Override
    public Employee getEmployeeById(
            final Long employeeId
    ) {
        final EmployeeEntity employeeEntityFromDb = employeeRepository
                .findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Verilen id değerine sahip bir employee bulunamadı."));

        return EmployeeMapper.toDomainModel(employeeEntityFromDb);
    }

    @Override
    public EmployeeAggregateWithBranch getEmployeeByIdAggregateWithBranch(
            Long employeeId
    ) {
        final EmployeeEntity employeeEntityFromDb = employeeRepository
                .findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Verilen id değerine sahip bir employee bulunamadı."));


        return EmployeeMapper.toEmployeeAggregateWithBranch(employeeEntityFromDb);
    }

    @Override
    public List<Employee> getAllEmployees(
    ) {
        final List<EmployeeEntity> employeeEntitiesFromDb = employeeRepository
                .findAll();

        return EmployeeMapper.toDomainModel(employeeEntitiesFromDb);
    }

    @Override
    public List<EmployeeAggregateWithBranch> getAllEmployeesWithBranch(
    ) {
        final List<EmployeeEntity> employeeEntitiesFromDb = employeeRepository
                .findAll();

        return EmployeeMapper.toEmployeeAggregateWithBranch(employeeEntitiesFromDb);
    }
}
