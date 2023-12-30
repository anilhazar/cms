package com.anil.vtys.cms.service;

import com.anil.vtys.cms.repository.ProjectRepository;

public class ProjectServiceImply implements ProjectService{
    private final ProjectRepository projectRepository;

    public ProjectServiceImply(ProjectRepository projectRepository){
        this.projectRepository=projectRepository;
    }
}
