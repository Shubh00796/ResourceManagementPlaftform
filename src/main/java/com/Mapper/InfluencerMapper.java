package com.Mapper;


import com.DTOS.InfluencerDTO;
import com.Domian.InfluencerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface InfluencerMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "socialMediaPlatform", source = "socialMediaPlatform")
    @Mapping(target = "followerCount", source = "followerCount")
    @Mapping(target = "engagementRate", source = "engagementRate")
    @Mapping(target = "totalEarnings", source = "totalEarnings")
    InfluencerDTO toDto(InfluencerEntity influencerEntity);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "socialMediaPlatform", source = "socialMediaPlatform")
    @Mapping(target = "followerCount", source = "followerCount")
    @Mapping(target = "engagementRate", source = "engagementRate")
    @Mapping(target = "totalEarnings", source = "totalEarnings")
    InfluencerEntity toEntity(InfluencerDTO influencerDTO);

    @Mapping(target = "id", source = "id")
    void updateEntityFromDto(InfluencerDTO influencerDTO, @MappingTarget InfluencerEntity influencerEntity);
}