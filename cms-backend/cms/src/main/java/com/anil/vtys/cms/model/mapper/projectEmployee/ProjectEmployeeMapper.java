package com.anil.vtys.cms.model.mapper.projectEmployee;

import com.anil.vtys.cms.model.ProjectEmployee;
import com.anil.vtys.cms.model.entity.ProjectEmployeeEntity;
import com.anil.vtys.cms.model.mapper.employee.EmployeeMapper;
import com.anil.vtys.cms.model.mapper.project.ProjectMapper;

import java.util.List;

/**
 * {@link ProjectEmployeeEntity} Entity nesneleri ile {@link ProjectEmployee}
 * Domain model nesneleri arasındaki mapleme işlemlerini yürüten mapper sınıftır.
 */
public class ProjectEmployeeMapper {

    public static ProjectEmployee toDomainModel(
            final ProjectEmployeeEntity projectEmployeeEntity
    ) {
        return ProjectEmployee.builder()
                .id(projectEmployeeEntity.getId())
                .project(
                        ProjectMapper.toDomainModel(projectEmployeeEntity.getProjectEntity())
                )
                .employee(
                        EmployeeMapper.toDomainModel(projectEmployeeEntity.getEmployeeEntity())
                )
                .hour(projectEmployeeEntity.getHour())
                .build();
    }

    public static List<ProjectEmployee> toDomainModel(
            final List<ProjectEmployeeEntity> projectEmployeeEntities
    ) {
        return projectEmployeeEntities.stream()
                .map(ProjectEmployeeMapper::toDomainModel)
                .toList();
    }

    public static ProjectEmployeeEntity toEntity(
            final ProjectEmployee projectEmployeeDomainModel
    ) {
        return ProjectEmployeeEntity.builder()
                .id(projectEmployeeDomainModel.getId())
                .projectEntity(
                        ProjectMapper.toEntity(projectEmployeeDomainModel.getProject())
                )
                .employeeEntity(
                        EmployeeMapper.toEntity(projectEmployeeDomainModel.getEmployee())
                )
                .hour(projectEmployeeDomainModel.getHour())
                .build();
    }
}
