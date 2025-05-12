package com.ServiceImpl;

import com.DTOS.BorrowRequestDTO;
import com.Domian.BorrowRequestEntity;
import com.Domian.UserEntity;
import com.Mapper.BorrowRequestMapper;
import com.ReposiotryServices.BorrowRequestRepositoryService;
import com.Services.BorrowRequestService;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class BorrowRequestServiceImpl implements BorrowRequestService {
    private final BorrowRequestRepositoryService repositoryService;
    private final BorrowRequestMapper mapper;
    private final Validator validator;

    @Override
    public List<BorrowRequestDTO> getAllRequests() {
        return repositoryService.getAllRequests()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public BorrowRequestDTO getRequestById(Long id) {
        BorrowRequestEntity requestById = repositoryService.getRequestById(id);
        return mapper.toDto(requestById);
    }

    @Override
    public BorrowRequestDTO createRequest(BorrowRequestDTO request) {
        BorrowRequestEntity borrowRequestEntity = mapper.toEntity(request);
        validateBorrowRequest(borrowRequestEntity);
        BorrowRequestEntity savedBorrowRequest = repositoryService.createRequest(borrowRequestEntity);


        return mapper.toDto(savedBorrowRequest);
    }

    @Override
    public BorrowRequestDTO updateRequestStatus(BorrowRequestDTO request) {
        BorrowRequestEntity existingRequest = repositoryService.getRequestById(request.getId());
        mapper.updateEntityFromDto(request, existingRequest);
        BorrowRequestEntity updatedBorrowREquest = repositoryService.createRequest(existingRequest);


        return mapper.toDto(updatedBorrowREquest);
    }

    @Override
    public List<BorrowRequestDTO> getPendingRequestsByUser(Long borrowerId) {
        return repositoryService.getPendingRequestsByUser(borrowerId)
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteRequest(Long id) {
        repositoryService.deleteRequest(id);

    }

    private void validateBorrowRequest(BorrowRequestEntity borrowRequestEntity) {
        Set<ConstraintViolation<BorrowRequestEntity>> violations = validator.validate(borrowRequestEntity);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }
}
