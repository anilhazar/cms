package com.anil.vtys.cms.model;

import com.anil.vtys.cms.model.entity.EmployeeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * {@link EmployeeEntity} Entity nesnesinin DomainModel objesidir.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private Long id;
    private int age;
    private char gender;
    private Date birthDate;
    private String firstName;
    private String lastName;
}
