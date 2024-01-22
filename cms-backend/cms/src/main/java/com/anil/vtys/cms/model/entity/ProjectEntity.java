package com.anil.vtys.cms.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "project")
public class ProjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "branch_id"
    )
    private BranchEntity branchEntity;

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "projectEntity"
    )
    private Set<ProjectEmployeeEntity> projectEmployeeEntity;

}