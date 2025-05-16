package com.Mapper;

import com.DTOS.OfferDTO;
import com.Domian.OfferEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface OfferMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "influencerId", source = "influencerId")
    @Mapping(target = "brandId", source = "brandId")
    @Mapping(target = "amount", source = "amount")
    @Mapping(target = "status", source = "status")
    OfferDTO toDto(OfferEntity offerEntity);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "influencerId", source = "influencerId")
    @Mapping(target = "brandId", source = "brandId")
    @Mapping(target = "amount", source = "amount")
    @Mapping(target = "status", source = "status")
    OfferEntity toEntity(OfferDTO offerDTO);

    @Mapping(target = "id", source = "id")
    void updateEntityFromDto(OfferDTO offerDTO, @MappingTarget OfferEntity offerEntity);
}