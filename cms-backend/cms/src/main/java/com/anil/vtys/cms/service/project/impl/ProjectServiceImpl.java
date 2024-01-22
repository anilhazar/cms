package com.anil.vtys.cms.service.project.impl;

import com.anil.vtys.cms.model.Project;
import com.anil.vtys.cms.model.entity.ProjectEntity;
import com.anil.vtys.cms.model.mapper.project.ProjectMapper;
import com.anil.vtys.cms.repository.ProjectRepository;
import com.anil.vtys.cms.service.project.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    @Override
    public Project getProjectById(
            final Long projectId
    ) {
        final ProjectEntity projectEntityFromDb = projectRepository
                .findById(projectId)
                .orElseThrow(() -> new RuntimeException("ID değeri belirtilen Proje bulunamadı."));

        return ProjectMapper.toDomainModel(projectEntityFromDb);
    }

    @Override
    public List<Project> getAllProjects(
    ) {
        final List<ProjectEntity> projectsFromDb = projectRepository
                .findAll();

        if (Objects.isNull(projectsFromDb)) {
            throw new RuntimeException("Hiç Proje Bulunamadı.");
        }

        return ProjectMapper.toDomainModel(projectsFromDb);
    }
}
