package com.anil.vtys.cms.service.project.impl;

import com.anil.vtys.cms.model.entity.ProjectEntity;
import com.anil.vtys.cms.repository.ProjectRepository;
import com.anil.vtys.cms.service.project.ProjectDeleteService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ProjectDeleteServiceImpl implements ProjectDeleteService {

    private final ProjectRepository projectRepository;

    @Override
    @Transactional
    public String deleteProjectById(
            final Long projectId
    ) {
        final ProjectEntity projectEntityToBeDelete = projectRepository
                .findById(projectId)
                .orElseThrow(() -> new RuntimeException("ID değeri belirtilen Proje bulunamadı."));

        if (Objects.nonNull(projectEntityToBeDelete.getBranchEntity())){
            projectEntityToBeDelete.setBranchEntity(null);
        }

        projectRepository.delete(projectEntityToBeDelete);

        return projectId + " ID numaralı Proje Başarıyla Silindi.";
    }
}
