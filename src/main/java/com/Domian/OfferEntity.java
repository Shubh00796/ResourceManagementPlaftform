package com.Domian;

import com.Domian.Enums.OfferStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OfferEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long influencerId; // Foreign key to InfluencerEntity
    private Long brandId; // Foreign key to BrandEntity
    private Double amount;
    @Enumerated(EnumType.STRING)
    private OfferStatus status;
}