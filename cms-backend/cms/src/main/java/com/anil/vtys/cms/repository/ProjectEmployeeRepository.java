package com.anil.vtys.cms.repository;

import com.anil.vtys.cms.model.entity.EmployeeEntity;
import com.anil.vtys.cms.model.entity.ProjectEmployeeEntity;
import com.anil.vtys.cms.model.entity.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProjectEmployeeRepository extends JpaRepository<ProjectEmployeeEntity, Long> {
    boolean existsProjectEmployeeEntityByProjectEntityAndEmployeeEntity(
            final ProjectEntity projectEntity,
            final EmployeeEntity employeeEntity
    );

    Optional<ProjectEmployeeEntity> findProjectEmployeeEntityByProjectEntityAndEmployeeEntity(
            final ProjectEntity projectEntity,
            final EmployeeEntity employeeEntity
    );
}
