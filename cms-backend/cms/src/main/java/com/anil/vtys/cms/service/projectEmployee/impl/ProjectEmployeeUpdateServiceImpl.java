package com.anil.vtys.cms.service.projectEmployee.impl;

import com.anil.vtys.cms.model.Employee;
import com.anil.vtys.cms.model.Project;
import com.anil.vtys.cms.model.ProjectEmployee;
import com.anil.vtys.cms.model.dto.projectEmployee.ProjectEmployeeCreateOrUpdateRequest;
import com.anil.vtys.cms.model.entity.ProjectEmployeeEntity;
import com.anil.vtys.cms.model.mapper.employee.EmployeeMapper;
import com.anil.vtys.cms.model.mapper.project.ProjectMapper;
import com.anil.vtys.cms.model.mapper.projectEmployee.ProjectEmployeeMapper;
import com.anil.vtys.cms.repository.ProjectEmployeeRepository;
import com.anil.vtys.cms.service.projectEmployee.ProjectEmployeeCreateService;
import com.anil.vtys.cms.service.projectEmployee.ProjectEmployeeUpdateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectEmployeeUpdateServiceImpl implements ProjectEmployeeUpdateService {

    private final ProjectEmployeeRepository projectEmployeeRepository;
    private final ProjectEmployeeCreateService projectEmployeeCreateService;

    @Override
    public ProjectEmployee updateProjectEmployee(
            final Project project,
            final Employee employee,
            final ProjectEmployeeCreateOrUpdateRequest projectEmployeeCreateOrUpdateRequest
    ) {
        if (Boolean.FALSE.equals(projectEmployeeRepository
                .existsProjectEmployeeEntityByProjectEntityAndEmployeeEntity(
                        ProjectMapper.toEntity(project),
                        EmployeeMapper.toEntity(employee)
                ))
        ) {
            return projectEmployeeCreateService.createProjectEmployee(
                    project,
                    employee,
                    projectEmployeeCreateOrUpdateRequest
            );
        }

        final ProjectEmployeeEntity projectEmployeeEntityToBeUpdate = projectEmployeeRepository
                .findProjectEmployeeEntityByProjectEntityAndEmployeeEntity(
                        ProjectMapper.toEntity(project),
                        EmployeeMapper.toEntity(employee)
                )
                .orElseThrow(() -> new RuntimeException("Veritabanında Bozulma Mevcut"));

        projectEmployeeEntityToBeUpdate.setHour(projectEmployeeCreateOrUpdateRequest.getHour());

        projectEmployeeRepository.save(projectEmployeeEntityToBeUpdate);

        return ProjectEmployeeMapper.toDomainModel(projectEmployeeEntityToBeUpdate);
    }

}
