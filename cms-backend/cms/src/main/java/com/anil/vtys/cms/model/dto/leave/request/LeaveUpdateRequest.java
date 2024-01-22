package com.anil.vtys.cms.model.dto.leave.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class LeaveUpdateRequest {
    @NotBlank
    private String reason;
    private Date startDate;
    private Date endDate;
}
