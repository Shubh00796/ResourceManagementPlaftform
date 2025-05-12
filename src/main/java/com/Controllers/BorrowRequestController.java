package com.Controllers;

import com.DTOS.BorrowRequestDTO;
import com.Services.BorrowRequestService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/borrow-requests")
@RequiredArgsConstructor
public class BorrowRequestController {

    private final BorrowRequestService borrowRequestService;

    @GetMapping
    public ResponseEntity<List<BorrowRequestDTO>> getAllRequests() {
        List<BorrowRequestDTO> requests = borrowRequestService.getAllRequests();
        return ResponseEntity.ok(requests);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BorrowRequestDTO> getRequestById(@PathVariable Long id) {
        BorrowRequestDTO request = borrowRequestService.getRequestById(id);
        return ResponseEntity.ok(request);
    }

    @PostMapping
    public ResponseEntity<BorrowRequestDTO> createRequest(@RequestBody @Valid BorrowRequestDTO request) {
        BorrowRequestDTO createdRequest = borrowRequestService.createRequest(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRequest);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BorrowRequestDTO> updateRequestStatus(@PathVariable Long id, @RequestBody @Valid BorrowRequestDTO request) {
        BorrowRequestDTO updatedRequest = borrowRequestService.updateRequestStatus(request);
        return ResponseEntity.ok(updatedRequest);
    }

    @GetMapping("/pending/user/{userId}")
    public ResponseEntity<List<BorrowRequestDTO>> getPendingRequestsByUser(@PathVariable Long borrowerId) {
        List<BorrowRequestDTO> requests = borrowRequestService.getPendingRequestsByUser(borrowerId);
        return ResponseEntity.ok(requests);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRequest(@PathVariable Long id) {
        borrowRequestService.deleteRequest(id);
        return ResponseEntity.noContent().build();
    }
}