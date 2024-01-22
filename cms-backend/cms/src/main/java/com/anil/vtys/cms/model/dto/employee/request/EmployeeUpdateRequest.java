package com.anil.vtys.cms.model.dto.employee.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class EmployeeUpdateRequest {
    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    private int age;
    private char gender;
    private Date birthDate;
}
