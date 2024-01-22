package com.anil.vtys.cms.service.projectEmployee;

import com.anil.vtys.cms.model.Employee;
import com.anil.vtys.cms.model.Project;
import com.anil.vtys.cms.model.ProjectEmployee;
import com.anil.vtys.cms.model.dto.projectEmployee.ProjectEmployeeCreateOrUpdateRequest;

public interface ProjectEmployeeCreateService {
    ProjectEmployee createProjectEmployee(
            final Project project,
            final Employee employee,
            final ProjectEmployeeCreateOrUpdateRequest projectEmployeeCreateOrUpdateRequest
    );
}
