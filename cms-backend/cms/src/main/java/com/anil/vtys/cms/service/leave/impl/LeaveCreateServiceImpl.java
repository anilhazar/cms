package com.anil.vtys.cms.service.leave.impl;

import com.anil.vtys.cms.model.Employee;
import com.anil.vtys.cms.model.Leave;
import com.anil.vtys.cms.model.dto.leave.request.LeaveCreateRequest;
import com.anil.vtys.cms.model.entity.LeaveEntity;
import com.anil.vtys.cms.model.mapper.employee.EmployeeMapper;
import com.anil.vtys.cms.model.mapper.leave.LeaveMapper;
import com.anil.vtys.cms.repository.LeaveRepository;
import com.anil.vtys.cms.service.leave.LeaveCreateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LeaveCreateServiceImpl implements LeaveCreateService {

    private final LeaveRepository leaveRepository;

    @Override
    public Leave createLeaveForEmployee(
            final Employee employee,
            final LeaveCreateRequest leaveCreateRequest
    ) {
        final LeaveEntity leaveEntityToBeSave = LeaveEntity.builder()
                .reason(leaveCreateRequest.getReason())
                .startDate(leaveCreateRequest.getStartDate())
                .endDate(leaveCreateRequest.getEndDate())
                .employeeEntity(
                        EmployeeMapper.toEntity(employee)
                )
                .build();

        leaveRepository.save(leaveEntityToBeSave);

        return LeaveMapper.toDomainModel(leaveEntityToBeSave);
    }
}
