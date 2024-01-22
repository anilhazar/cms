package com.anil.vtys.cms.service.project;

import com.anil.vtys.cms.model.Project;
import com.anil.vtys.cms.model.dto.project.ProjectCreateRequest;

public interface ProjectCreateService {
    Project createProject(
            final ProjectCreateRequest projectCreateRequest
    );
}
