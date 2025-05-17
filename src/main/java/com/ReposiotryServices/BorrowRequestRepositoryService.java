package com.ReposiotryServices;

import com.Domian.BorrowRequestEntity;
import com.Exceptions.ResourceNotFoundException;
import com.Repository.BorrowRequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BorrowRequestRepositoryService {
    private final BorrowRequestRepository requestRepository;

    public List<BorrowRequestEntity> getAllRequests() {
        return requestRepository.findAll();
    }


    public BorrowRequestEntity getRequestById(Long id) {
        return getOredElseThrow(id);
    }


    public BorrowRequestEntity createRequest(BorrowRequestEntity borrowRequestEntity) {
        return requestRepository.save(borrowRequestEntity);
    }


    public void deleteRequest(Long id) {
        requestRepository.deleteById(id);

    }

    public List<BorrowRequestEntity> getPendingRequestsByUser(Long borrowerId) {
        return requestRepository.findByBorrowerId(borrowerId);

    }

    private BorrowRequestEntity getOredElseThrow(Long id) {
        return requestRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ID not found for the bgiven request" + id));
    }

}
