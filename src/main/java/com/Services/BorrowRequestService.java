package com.Services;

import com.DTOS.BorrowRequestDTO;
import com.Domian.UserEntity;

import java.util.List;

public interface BorrowRequestService {
    List<BorrowRequestDTO> getAllRequests();

    BorrowRequestDTO getRequestById(Long id);

    BorrowRequestDTO createRequest(BorrowRequestDTO request);

    BorrowRequestDTO updateRequestStatus(BorrowRequestDTO request);

    List<BorrowRequestDTO> getPendingRequestsByUser(Long borrowerId);

    void deleteRequest(Long id);
}