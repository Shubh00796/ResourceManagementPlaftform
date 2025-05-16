package com.DTOS;

import com.Domian.Enums.OfferStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OfferDTO {
    private Long id;
    private Long influencerId;
    private Long brandId;
    private Double amount;
    private OfferStatus status;
}