package com.anil.vtys.cms.repository;

import com.anil.vtys.cms.model.entity.ProjectEmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorksOnRepository extends JpaRepository<ProjectEmployeeEntity, Long> {
}
