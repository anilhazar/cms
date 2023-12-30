package com.anil.vtys.cms.service;

import com.anil.vtys.cms.repository.LeaveRequestRepository;

public class LeaveRequestServiceImply implements LeaveRequestService {
    private final LeaveRequestRepository leaveRequestRepository;

    public LeaveRequestServiceImply(LeaveRequestRepository leaveRequestRepository){
        this.leaveRequestRepository=leaveRequestRepository;
    }
}
