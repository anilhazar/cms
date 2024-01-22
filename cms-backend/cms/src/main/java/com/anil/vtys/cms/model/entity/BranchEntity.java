package com.anil.vtys.cms.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "branch")
public class BranchEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "branchEntity"
    )
    private Set<EmployeeEntity> employeeEntityEntities = new HashSet<>();

    @OneToMany(mappedBy = "branchEntity")
    private Set<ProjectEntity> projectEntities = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<EmployeeEntity> getEmployeeEntityEntities() {
        return employeeEntityEntities;
    }

    public void setEmployeeEntityEntities(Set<EmployeeEntity> employeeEntityEntities) {
        this.employeeEntityEntities = employeeEntityEntities;
    }

    public Set<ProjectEntity> getProjectEntities() {
        return projectEntities;
    }

    public void setProjectEntities(Set<ProjectEntity> projectEntities) {
        this.projectEntities = projectEntities;
    }

    // UTIL METHODS

    public void addEmployee(
            final EmployeeEntity employeeEntity
    ) {
        if (employeeEntityEntities == null){
            this.employeeEntityEntities = new HashSet<>();
        }

        this.employeeEntityEntities.add(employeeEntity);
    }
}