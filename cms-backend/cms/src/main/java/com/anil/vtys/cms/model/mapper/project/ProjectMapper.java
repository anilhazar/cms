package com.anil.vtys.cms.model.mapper.project;

import com.anil.vtys.cms.model.Project;
import com.anil.vtys.cms.model.entity.ProjectEntity;

import java.util.List;

/**
 * {@link ProjectEntity} Entity nesneleri ile {@link Project} Domain Model nesneleri
 * arasında mapleme işlemlerini yürüten mapper sınıftır.
 */
public class ProjectMapper {

    public static Project toDomainModel(
            final ProjectEntity projectEntity
    ) {
        return Project.builder()
                .id(projectEntity.getId())
                .name(projectEntity.getName())
                .build();
    }

    public static List<Project> toDomainModel(
            final List<ProjectEntity> projectEntities
    ) {
        return projectEntities.stream()
                .map(ProjectMapper::toDomainModel)
                .toList();
    }

    public static ProjectEntity toEntity(
            final Project projectDomainModel
    ) {
        return ProjectEntity.builder()
                .id(projectDomainModel.getId())
                .name(projectDomainModel.getName())
                .build();
    }
}
