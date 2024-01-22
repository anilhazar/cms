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
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectEmployeeCreateServiceImpl implements ProjectEmployeeCreateService {

    private final ProjectEmployeeRepository projectEmployeeRepository;

    @Override
    public ProjectEmployee createProjectEmployee(
            final Project project,
            final Employee employee,
            final ProjectEmployeeCreateOrUpdateRequest projectEmployeeCreateOrUpdateRequest
    ) {
        final ProjectEmployeeEntity projectEmployeeEntityToBeSave = ProjectEmployeeEntity.builder()
                .projectEntity(
                        ProjectMapper.toEntity(project)
                )
                .employeeEntity(
                        EmployeeMapper.toEntity(employee)
                )
                .hour(projectEmployeeCreateOrUpdateRequest.getHour())
                .build();

        projectEmployeeRepository.save(projectEmployeeEntityToBeSave);

        return ProjectEmployeeMapper.toDomainModel(projectEmployeeEntityToBeSave);
    }
}
