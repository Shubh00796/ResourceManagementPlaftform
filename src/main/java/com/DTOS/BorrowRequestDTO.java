package com.DTOS;

import com.Domian.Enums.Status;
import lombok.Data;

import java.time.LocalDate;

@Data
public class BorrowRequestDTO {
    private Long id;
    private Long borrowerId;
    private Long resourceId;
    private LocalDate pickupDate;
    private LocalDate returnDate;
    private Status status;
}
