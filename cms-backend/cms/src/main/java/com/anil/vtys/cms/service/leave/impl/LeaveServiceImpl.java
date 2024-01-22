package com.anil.vtys.cms.service.leave.impl;

import com.anil.vtys.cms.model.Employee;
import com.anil.vtys.cms.model.Leave;
import com.anil.vtys.cms.model.entity.LeaveEntity;
import com.anil.vtys.cms.model.mapper.employee.EmployeeMapper;
import com.anil.vtys.cms.model.mapper.leave.LeaveMapper;
import com.anil.vtys.cms.repository.LeaveRepository;
import com.anil.vtys.cms.service.leave.LeaveService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LeaveServiceImpl implements LeaveService {

    private final LeaveRepository leaveRepository;

    @Override
    public List<Leave> getAllLeavesFromEmployee(
            final Employee employee
    ) {
        final List<LeaveEntity> leaveEntitiesFromEmployee = leaveRepository
                .findLeaveEntitiesByEmployeeEntityOrderByStartDateDesc(
                        EmployeeMapper.toEntity(employee)
                );

        if (leaveEntitiesFromEmployee.isEmpty()){
            throw new RuntimeException("Belirtilen Çalışan İçin Hiç İzin Kaydı Bulunamadı.");
        }

        return LeaveMapper.toDomainModel(leaveEntitiesFromEmployee);
    }
}
