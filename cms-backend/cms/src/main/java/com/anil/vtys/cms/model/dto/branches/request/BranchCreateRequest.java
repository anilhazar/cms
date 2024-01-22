package com.anil.vtys.cms.model.dto.branches.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BranchCreateRequest {
    @NotBlank
    private String name;
}
