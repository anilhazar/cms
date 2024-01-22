package com.anil.vtys.cms.controller;

import com.anil.vtys.cms.model.Employee;
import com.anil.vtys.cms.model.Project;
import com.anil.vtys.cms.model.ProjectEmployee;
import com.anil.vtys.cms.model.dto.project.ProjectCreateRequest;
import com.anil.vtys.cms.model.dto.project.request.ProjectUpdateRequest;
import com.anil.vtys.cms.model.dto.projectEmployee.ProjectEmployeeCreateOrUpdateRequest;
import com.anil.vtys.cms.service.employee.EmployeeService;
import com.anil.vtys.cms.service.project.ProjectCreateService;
import com.anil.vtys.cms.service.project.ProjectDeleteService;
import com.anil.vtys.cms.service.project.ProjectService;
import com.anil.vtys.cms.service.project.ProjectUpdateService;
import com.anil.vtys.cms.service.projectEmployee.ProjectEmployeeUpdateService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/projects")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;
    private final ProjectCreateService projectCreateService;
    private final ProjectUpdateService projectUpdateService;
    private final ProjectDeleteService projectDeleteService;

    private final ProjectEmployeeUpdateService projectEmployeeUpdateService;

    private final EmployeeService employeeService;

    @PostMapping()
    public ResponseEntity<Project> createProject(
            @RequestBody @Valid final ProjectCreateRequest projectCreateRequest
    ) {
        final Project createdProject = projectCreateService
                .createProject(projectCreateRequest);

        return ResponseEntity.ok(createdProject);
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<Project> getProjectById(
            @PathVariable("projectId") final Long projectId
    ) {
        final Project projectFromDb = projectService
                .getProjectById(projectId);

        return ResponseEntity.ok(projectFromDb);
    }

    @GetMapping()
    public ResponseEntity<List<Project>> getAllProjects(
    ) {
        final List<Project> projectsFromDb = projectService
                .getAllProjects();

        return ResponseEntity.ok(projectsFromDb);
    }

    @PutMapping("/{projectId}")
    public ResponseEntity<Project> updateProjectById(
            @PathVariable("projectId") final Long projectId,
            @RequestBody @Valid final ProjectUpdateRequest projectUpdateRequest
    ) {
        final Project updatedProject = projectUpdateService
                .updateProjectById(
                        projectId,
                        projectUpdateRequest
                );

        return ResponseEntity.ok(updatedProject);
    }

    @PostMapping("/{projectId}/addEmployee/{employeeId}")
    public ResponseEntity<ProjectEmployee> addEmployeeToProject(
            @PathVariable("projectId") final Long projectId,
            @PathVariable("employeeId") final Long employeeId,
            @RequestBody @Valid final ProjectEmployeeCreateOrUpdateRequest projectEmployeeCreateOrUpdateRequest
    ) {
        final Employee employee = employeeService
                .getEmployeeById(employeeId);

        final Project project = projectService
                .getProjectById(projectId);

        final ProjectEmployee updatedProjectEmployee = projectEmployeeUpdateService
                .updateProjectEmployee(
                        project,
                        employee,
                        projectEmployeeCreateOrUpdateRequest
                );

        return ResponseEntity.ok(updatedProjectEmployee);

    }

    @DeleteMapping("/{projectId}")
    public ResponseEntity<String> deleteProjectById(
            @PathVariable("projectId") final Long projectId
    ) {
        final String message = projectDeleteService
                .deleteProjectById(projectId);

        return ResponseEntity.ok(message);
    }
}
