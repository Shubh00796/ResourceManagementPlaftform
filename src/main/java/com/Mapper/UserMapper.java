package com.Mapper;

import com.DTOS.UserDTO;
import com.Domian.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserEntity toEntity(UserDTO dto);

    UserDTO toDto(UserEntity entity);
    void updateEntityFromDto(UserDTO dto, @MappingTarget UserEntity entity);

}