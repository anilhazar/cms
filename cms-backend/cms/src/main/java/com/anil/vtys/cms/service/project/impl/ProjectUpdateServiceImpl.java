package com.anil.vtys.cms.service.project.impl;

import com.anil.vtys.cms.model.Project;
import com.anil.vtys.cms.model.dto.project.request.ProjectUpdateRequest;
import com.anil.vtys.cms.model.entity.ProjectEntity;
import com.anil.vtys.cms.model.mapper.project.ProjectMapper;
import com.anil.vtys.cms.repository.ProjectRepository;
import com.anil.vtys.cms.service.project.ProjectUpdateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectUpdateServiceImpl implements ProjectUpdateService {

    private final ProjectRepository projectRepository;

    @Override
    public Project updateProjectById(
            final Long projectId,
            final ProjectUpdateRequest projectUpdateRequest
    ) {
        final ProjectEntity projectEntityToBeUpdate = projectRepository
                .findById(projectId)
                .orElseThrow(() -> new RuntimeException("ID değeri belirtilen Proje bulunamadı."));

        projectEntityToBeUpdate.setName(projectUpdateRequest.getName());

        projectRepository.save(projectEntityToBeUpdate);

        return ProjectMapper.toDomainModel(projectEntityToBeUpdate);
    }
}
