package com.Mapper;

import com.DTOS.BorrowRequestDTO;
import com.Domian.BorrowRequestEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface BorrowRequestMapper {

    @Mapping(target = "id", ignore = true)

    BorrowRequestEntity toEntity(BorrowRequestDTO dto);


    BorrowRequestDTO toDto(BorrowRequestEntity entity);

    @Mapping(target = "id", ignore = true)

    void updateEntityFromDto(BorrowRequestDTO dto, @MappingTarget BorrowRequestEntity entity);
}
