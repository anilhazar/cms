package com.anil.vtys.cms.service.project.impl;

import com.anil.vtys.cms.model.Project;
import com.anil.vtys.cms.model.dto.project.ProjectCreateRequest;
import com.anil.vtys.cms.model.entity.ProjectEntity;
import com.anil.vtys.cms.model.mapper.project.ProjectMapper;
import com.anil.vtys.cms.repository.ProjectRepository;
import com.anil.vtys.cms.service.project.ProjectCreateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectCreateServiceImpl implements ProjectCreateService {

    private final ProjectRepository projectRepository;

    @Override
    public Project createProject(
           final ProjectCreateRequest projectCreateRequest
    ) {
        final ProjectEntity projectEntityToBeSave = ProjectEntity.builder()
                .name(projectCreateRequest.getName())
                .build();

        projectRepository.save(projectEntityToBeSave);

        return ProjectMapper.toDomainModel(projectEntityToBeSave);
    }
}
