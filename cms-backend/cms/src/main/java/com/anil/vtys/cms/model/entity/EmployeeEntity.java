package com.anil.vtys.cms.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "age")
    private int age;

    @Column(name = "gender")
    private char gender;

    @Column(name = "birth_date")
    private Date birthDate;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "branch_id"
    )
    private BranchEntity branchEntity;

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "employeeEntity"
    )
    private Set<LeaveEntity> leaveEntities;

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "employeeEntity"
    )
    private Set<ProjectEmployeeEntity> projectEmployeeEntities;

}
