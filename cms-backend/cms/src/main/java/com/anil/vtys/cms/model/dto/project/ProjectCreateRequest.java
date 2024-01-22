package com.anil.vtys.cms.model.dto.project;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProjectCreateRequest {
    @NotBlank
    private String name;
}
