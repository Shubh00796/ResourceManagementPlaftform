package com.DTOS;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InfluencerDTO {
    private Long id;
    private String name;
    private String socialMediaPlatform;
    private Long followerCount;
    private Double engagementRate;
    private Double totalEarnings;
}
