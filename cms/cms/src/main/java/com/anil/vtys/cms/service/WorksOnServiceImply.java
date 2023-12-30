package com.anil.vtys.cms.service;

import com.anil.vtys.cms.repository.WorksOnRepository;

public class WorksOnServiceImply implements WorksOnService{
    private final WorksOnRepository worksOnRepository;

    public WorksOnServiceImply(WorksOnRepository worksOnRepository){
        this.worksOnRepository=worksOnRepository;
    }
}
