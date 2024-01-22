package com.anil.vtys.cms.controller;

import com.anil.vtys.cms.model.Employee;
import com.anil.vtys.cms.model.Leave;
import com.anil.vtys.cms.model.dto.leave.request.LeaveCreateRequest;
import com.anil.vtys.cms.model.dto.leave.request.LeaveUpdateRequest;
import com.anil.vtys.cms.service.employee.EmployeeService;
import com.anil.vtys.cms.service.leave.LeaveCreateService;
import com.anil.vtys.cms.service.leave.LeaveDeleteService;
import com.anil.vtys.cms.service.leave.LeaveService;
import com.anil.vtys.cms.service.leave.LeaveUpdateService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/leaves")
@RequiredArgsConstructor
public class LeaveController {

    private final LeaveService leaveService;
    private final LeaveCreateService leaveCreateService;
    private final LeaveDeleteService leaveDeleteService;
    private final LeaveUpdateService leaveUpdateService;

    private final EmployeeService employeeService;

    @PostMapping("/employee/{employeeId}")
    public ResponseEntity<Leave> createLeaveForEmployee(
            @PathVariable("employeeId") final Long employeeId,
            @RequestBody @Valid final LeaveCreateRequest leaveCreateRequest
    ) {
        final Employee employee = employeeService.getEmployeeById(employeeId);

        final Leave leave = leaveCreateService.createLeaveForEmployee(
                employee,
                leaveCreateRequest
        );

        return ResponseEntity.ok(leave);
    }

    /**
     * ID değeri belirtilen Employee'nin bu güne kadar aldığı <br>
     * tüm izinleri geriye dönen endpoint.
     *
     * @return
     */
    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<Leave>> getAllLeavesFromEmployee(
            @PathVariable("employeeId") final Long employeeId
    ) {
        final Employee employee = employeeService.getEmployeeById(employeeId);

        final List<Leave> leavesFromEmployee = leaveService
                .getAllLeavesFromEmployee(employee);

        return ResponseEntity.ok(leavesFromEmployee);
    }

    @PutMapping("/{leaveId}")
    public ResponseEntity<Leave> updateLeaveById(
            @PathVariable("leaveId") final Long leaveId,
            @RequestBody @Valid final LeaveUpdateRequest leaveUpdateRequest
    ) {
        final Leave updatedLeave = leaveUpdateService
                .updateLeaveById(
                        leaveId,
                        leaveUpdateRequest
                );

        return ResponseEntity.ok(updatedLeave);
    }

    @DeleteMapping("/{leaveId}")
    public ResponseEntity<String> deleteLeaveById(
            @PathVariable("leaveId") final Long leaveId
    ) {
        final String message = leaveDeleteService.deleteLeave(leaveId);

        return ResponseEntity.ok(message);
    }


}
