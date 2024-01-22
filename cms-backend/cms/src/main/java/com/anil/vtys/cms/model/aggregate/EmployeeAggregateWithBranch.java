package com.anil.vtys.cms.model.aggregate;

import com.anil.vtys.cms.model.Branch;
import com.anil.vtys.cms.model.Employee;
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
public class EmployeeAggregateWithBranch {
    private Employee employee;
    private Branch branch;
}
