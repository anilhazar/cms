package com.anil.vtys.cms.model;

import com.anil.vtys.cms.model.entity.LeaveEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * {@link LeaveEntity} Entity nesnesinin Domain Model Objesidir.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Leave {
    private Long id;
    private String reason;
    private Date startDate;
    private Date endDate;
}
