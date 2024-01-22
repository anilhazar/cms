package com.anil.vtys.cms.controller;

import com.anil.vtys.cms.model.Employee;
import com.anil.vtys.cms.model.aggregate.EmployeeAggregateWithBranch;
import com.anil.vtys.cms.model.dto.employee.request.EmployeeCreateRequest;
import com.anil.vtys.cms.model.dto.employee.request.EmployeeUpdateRequest;
import com.anil.vtys.cms.service.employee.EmployeeCreateService;
import com.anil.vtys.cms.service.employee.EmployeeDeleteService;
import com.anil.vtys.cms.service.employee.EmployeeService;
import com.anil.vtys.cms.service.employee.EmployeeUpdateService;
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
@RequestMapping("/api/v1/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;
    private final EmployeeCreateService employeeCreateService;
    private final EmployeeUpdateService employeeUpdateService;
    private final EmployeeDeleteService employeeDeleteService;


    @PostMapping()
    public ResponseEntity<Employee> createEmployee(
            @RequestBody @Valid final EmployeeCreateRequest employeeCreateRequest
    ) {
        final Employee createdEmployee = employeeCreateService
                .createEmployee(employeeCreateRequest);

        return ResponseEntity.ok(createdEmployee);
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<Employee> getEmployeeById(
            @PathVariable("employeeId") final Long employeeId
    ) {
        final Employee employeeFromDb = employeeService
                .getEmployeeById(employeeId);

        return ResponseEntity.ok(employeeFromDb);
    }

    @GetMapping("/{employeeId}/withBranch")
    public ResponseEntity<EmployeeAggregateWithBranch> getEmployeeByIdWithBranch(
            @PathVariable("employeeId") final Long employeeId
    ) {
        final EmployeeAggregateWithBranch employeeFromDb = employeeService
                .getEmployeeByIdAggregateWithBranch(employeeId);

        return ResponseEntity.ok(employeeFromDb);
    }

    @GetMapping()
    public ResponseEntity<List<Employee>> getAllEmployees(
    ) {
        final List<Employee> employeesFromDb = employeeService
                .getAllEmployees();

        return ResponseEntity.ok(employeesFromDb);
    }

    @GetMapping("/withBranch")
    public ResponseEntity<List<EmployeeAggregateWithBranch>> getAllEmployeesWithBranch(
    ) {
        final List<EmployeeAggregateWithBranch> employeesFromDb = employeeService
                .getAllEmployeesWithBranch();

        return ResponseEntity.ok(employeesFromDb);
    }

    @PutMapping("/{employeeId}")
    public ResponseEntity<Employee> updateEmployeeById(
            @PathVariable("employeeId") final Long employeeId,
            @RequestBody @Valid final EmployeeUpdateRequest employeeUpdateRequest
    ) {
        final Employee updatedEmployee = employeeUpdateService
                .updateEmployeeById(employeeId, employeeUpdateRequest);

        return ResponseEntity.ok(updatedEmployee);
    }

    /**
     * ID Değeri belirtilen Employee'nin Branch ile ilişkisini koparan <br>
     * Employee nesnesinin branch alanını null yapan endpointtir.
     *
     * @param employeeId
     * @return
     */
    @PutMapping("/{employeeId}/detachBranch")
    public ResponseEntity<Void> detachBranchOfEmployeeById(
            @PathVariable("employeeId") final Long employeeId
    ) {
        employeeUpdateService.detachBranchOfEmployeeById(employeeId);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/{employeeId}/changeBranch/{branchId}")
    public ResponseEntity<Void> detachBranchOfEmployeeById(
            @PathVariable("employeeId") final Long employeeId,
            @PathVariable("branchId") final Long branchId
    ) {
        employeeUpdateService.changeBranchByEmployeeIdAndBranchId(
                employeeId,
                branchId
        );

        return ResponseEntity.ok().build();
    }


    @DeleteMapping("/{employeeId}")
    public ResponseEntity<String> deleteEmployeeById(
            @PathVariable("employeeId") final Long employeeId
    ) {
        final String message = employeeDeleteService.deleteEmployeeById(employeeId);

        return ResponseEntity.ok(message);
    }

}
