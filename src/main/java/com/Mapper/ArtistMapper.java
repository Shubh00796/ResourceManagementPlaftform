package com.Mapper;

import com.DTOS.ArtistDTO;
import com.Domian.Artist;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ArtistMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "genre", source = "genre")
    @Mapping(target = "albumIds", source = "albumIds")
    @Mapping(target = "songIds", source = "songIds")
    ArtistDTO toDto(Artist artist);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "genre", source = "genre")
    @Mapping(target = "albumIds", source = "albumIds")
    @Mapping(target = "songIds", source = "songIds")
    Artist toEntity(ArtistDTO artistDTO);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "genre", source = "genre")
    @Mapping(target = "albumIds", source = "albumIds")
    @Mapping(target = "songIds", source = "songIds")
    void updateEntityFromDto(ArtistDTO artistDTO, @MappingTarget Artist artist);
}