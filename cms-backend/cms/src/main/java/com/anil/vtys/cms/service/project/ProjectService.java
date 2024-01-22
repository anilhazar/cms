package com.anil.vtys.cms.service.project;

import com.anil.vtys.cms.model.Project;

import java.util.List;

public interface ProjectService {
    Project getProjectById(
            final Long projectId
    );

    List<Project> getAllProjects();
}
