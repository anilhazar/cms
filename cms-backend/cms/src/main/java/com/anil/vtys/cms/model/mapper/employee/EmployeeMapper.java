package com.anil.vtys.cms.model.mapper.employee;

import com.anil.vtys.cms.model.Employee;
import com.anil.vtys.cms.model.aggregate.EmployeeAggregateWithBranch;
import com.anil.vtys.cms.model.entity.BranchEntity;
import com.anil.vtys.cms.model.entity.EmployeeEntity;
import com.anil.vtys.cms.model.mapper.branch.BranchMapper;

import java.util.List;

/**
 * {@link EmployeeEntity} Entity nesneleri ile {@link Employee} Domain model nesneleri arasındaki
 * mapleme işlemlerini yürüten mapper sınıftır.
 */
public class EmployeeMapper {

    /**
     * Parametre olarak verilen {@link EmployeeEntity} nesnesini <br>
     * {@link Employee} DomainModel nesnesine dönüştüren metoddur.
     *
     * @param employeeEntity
     * @return
     */
    public static Employee toDomainModel(
            final EmployeeEntity employeeEntity
    ) {
        return Employee.builder()
                .id(employeeEntity.getId())
                .age(employeeEntity.getAge())
                .gender(employeeEntity.getGender())
                .birthDate(employeeEntity.getBirthDate())
                .firstName(employeeEntity.getFirstName())
                .lastName(employeeEntity.getLastName())
                .build();
    }

    /**
     * Parametre olarak verilen {@link EmployeeEntity} nesnelerini <br>
     * {@link Employee} DomainModel nesnelerine dönüştüren metoddur.
     *
     * @param employeeEntities
     * @return
     */
    public static List<Employee> toDomainModel(
            final List<EmployeeEntity> employeeEntities
    ) {
        return employeeEntities.stream()
                .map(EmployeeMapper::toDomainModel)
                .toList();
    }

    /**
     * Parametre olarak verilen {@link Employee} Domain Model nesnesini <br>
     * {@link EmployeeEntity} Entity nesnesine dönüştüren metoddur.
     *
     * @param employee
     * @return
     */
    public static EmployeeEntity toEntity(
            final Employee employee
    ) {
        return EmployeeEntity.builder()
                .id(employee.getId())
                .age(employee.getAge())
                .gender(employee.getGender())
                .birthDate(employee.getBirthDate())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .build();
    }

    public static EmployeeAggregateWithBranch toEmployeeAggregateWithBranch(
            final EmployeeEntity employeeEntity
    ) {
        return EmployeeAggregateWithBranch.builder()
                .employee(
                        toDomainModel(employeeEntity)
                )
                .branch(
                        employeeEntity.getBranchEntity() == null ? null :
                        BranchMapper.toDomainModel(employeeEntity.getBranchEntity())
                )
                .build();
    }

    public static List<EmployeeAggregateWithBranch> toEmployeeAggregateWithBranch(
            final List<EmployeeEntity> employeeEntities
    ) {
        return employeeEntities.stream()
                .map(EmployeeMapper::toEmployeeAggregateWithBranch)
                .toList();
    }
}
