package com.anil.vtys.cms.service.leave.impl;

import com.anil.vtys.cms.model.Leave;
import com.anil.vtys.cms.model.dto.leave.request.LeaveUpdateRequest;
import com.anil.vtys.cms.model.entity.LeaveEntity;
import com.anil.vtys.cms.model.mapper.leave.LeaveMapper;
import com.anil.vtys.cms.repository.LeaveRepository;
import com.anil.vtys.cms.service.leave.LeaveUpdateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LeaveUpdateServiceImpl implements LeaveUpdateService {

    private final LeaveRepository leaveRepository;

    @Override
    public Leave updateLeaveById(
            final Long leaveId,
            final LeaveUpdateRequest leaveUpdateRequest
    ) {
        final LeaveEntity leaveEntityToBeUpdate = leaveRepository
                .findById(leaveId)
                .orElseThrow(() -> new RuntimeException("ID Değeri belirtilen İzin Bulunamadı"));

        leaveEntityToBeUpdate.setReason(leaveUpdateRequest.getReason());
        leaveEntityToBeUpdate.setStartDate(leaveUpdateRequest.getStartDate());
        leaveEntityToBeUpdate.setEndDate(leaveUpdateRequest.getEndDate());

        leaveRepository.save(leaveEntityToBeUpdate);

        return LeaveMapper.toDomainModel(leaveEntityToBeUpdate);
    }
}
