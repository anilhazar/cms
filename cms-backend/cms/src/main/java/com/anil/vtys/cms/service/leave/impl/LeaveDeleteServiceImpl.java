package com.anil.vtys.cms.service.leave.impl;

import com.anil.vtys.cms.model.entity.LeaveEntity;
import com.anil.vtys.cms.repository.LeaveRepository;
import com.anil.vtys.cms.service.leave.LeaveDeleteService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class LeaveDeleteServiceImpl implements LeaveDeleteService {

    private final LeaveRepository leaveRepository;

    @Override
    @Transactional
    public String deleteLeave(
            final Long leaveId
    ) {
        final LeaveEntity leaveEntityToBeDelete = leaveRepository
                .findById(leaveId)
                .orElseThrow(()->new RuntimeException("ID Değeri Belirtilen İzin Bulunamadı!"));

        if (Objects.nonNull(leaveEntityToBeDelete.getEmployee())){
            leaveEntityToBeDelete.setEmployee(null);
        }

        leaveRepository.delete(leaveEntityToBeDelete);

        return leaveId + " ID değerine sahip İzin Başarıyla Silindi.";
    }
}
