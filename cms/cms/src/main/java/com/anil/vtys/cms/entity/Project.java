package com.anil.vtys.cms.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pId;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "b_id")
    private Branch branch;

    @OneToMany(mappedBy = "project")
    private Set<WorksOn> worksOn = new HashSet<>();

    public Long getpId() {
        return pId;
    }

    public void setpId(Long pId) {
        this.pId = pId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public Set<WorksOn> getWorksOn() {
        return worksOn;
    }

    public void setWorksOn(Set<WorksOn> worksOn) {
        this.worksOn = worksOn;
    }
}