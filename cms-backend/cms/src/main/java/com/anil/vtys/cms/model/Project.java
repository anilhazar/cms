package com.anil.vtys.cms.model;

import com.anil.vtys.cms.model.entity.BranchEntity;
import com.anil.vtys.cms.model.entity.ProjectEmployeeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
/**
 * {@link ProjectEmployeeEntity} Entity nesnelerinin Domain Model Objesidir.
 */
public class Project {
    private Long id;
    private String name;
}
