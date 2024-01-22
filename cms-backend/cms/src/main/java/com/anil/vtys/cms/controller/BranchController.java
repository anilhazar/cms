package com.anil.vtys.cms.controller;

import com.anil.vtys.cms.model.Branch;
import com.anil.vtys.cms.model.dto.branches.request.BranchCreateRequest;
import com.anil.vtys.cms.model.dto.branches.request.BranchUpdateRequest;
import com.anil.vtys.cms.service.branch.BranchCreateService;
import com.anil.vtys.cms.service.branch.BranchDeleteService;
import com.anil.vtys.cms.service.branch.BranchService;
import com.anil.vtys.cms.service.branch.BranchUpdateService;
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
@RequestMapping("/api/v1/branches")
@RequiredArgsConstructor
public class BranchController {

    private final BranchService branchService;
    private final BranchCreateService branchCreateService;
    private final BranchUpdateService branchUpdateService;
    private final BranchDeleteService branchDeleteService;

    @PostMapping()
    public ResponseEntity<Branch> createBranch(
            @RequestBody @Valid final BranchCreateRequest branchCreateRequest
    ) {
        final Branch createdBranch = branchCreateService
                .createBranch(branchCreateRequest);

        return ResponseEntity.ok(createdBranch);
    }

    @GetMapping("/{branchId}")
    public ResponseEntity<Branch> getBranchById(
            @PathVariable("branchId") final Long branchId
    ) {
        final Branch branchFromDB = branchService
                .getBranchById(branchId);

        return ResponseEntity.ok(branchFromDB);
    }

    @GetMapping()
    public ResponseEntity<List<Branch>> getAllBranches(
    ) {
        final List<Branch> branchesFromDb = branchService
                .getAllBranches();

        return ResponseEntity.ok(branchesFromDb);
    }



    @PutMapping("/{branchId}")
    public ResponseEntity<Branch> updateBranchById(
            @PathVariable("branchId") final Long branchId,
            @RequestBody @Valid final BranchUpdateRequest branchUpdateRequest
    ) {
        final Branch updatedBranch = branchUpdateService
                .updateBranchById(branchId,branchUpdateRequest);

        return ResponseEntity.ok(updatedBranch);
    }

    @DeleteMapping("/{branchId}")
    public ResponseEntity<String> deleteBranchById(
            @PathVariable("branchId") final Long branchId
    ) {
        final String message = branchDeleteService
                .deleteBranchById(branchId);

        return ResponseEntity.ok(message);
    }

}
