package com.anil.vtys.cms.model;

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
 * {@link ProjectEmployeeEntity} Entity Nesnelerinin Domain Model Objeleridir.
 */
public class ProjectEmployee {
    private Long id;
    private Employee employee;
    private Project project;
    private int hour;
}
