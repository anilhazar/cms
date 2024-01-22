package com.anil.vtys.cms.service.project;

import com.anil.vtys.cms.model.Project;
import com.anil.vtys.cms.model.dto.project.request.ProjectUpdateRequest;

public interface ProjectUpdateService {
    Project updateProjectById(
            final Long projectId,
            final ProjectUpdateRequest projectUpdateRequest
    );
}
