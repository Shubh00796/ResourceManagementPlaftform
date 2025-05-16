// AlbumMapper.java
package com.Mapper;

import com.DTOS.AlbumDTO;
import com.Domian.Album;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface AlbumMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "title", source = "title")
    @Mapping(target = "releaseYear", source = "releaseYear")
    @Mapping(target = "songIds", source = "songIds")
    @Mapping(target = "artistIds", source = "artistIds")
    AlbumDTO toDto(Album album);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "title", source = "title")
    @Mapping(target = "releaseYear", source = "releaseYear")
    @Mapping(target = "songIds", source = "songIds")
    @Mapping(target = "artistIds", source = "artistIds")
    Album toEntity(AlbumDTO albumDTO);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "title", source = "title")
    @Mapping(target = "releaseYear", source = "releaseYear")
    @Mapping(target = "songIds", source = "songIds")
    @Mapping(target = "artistIds", source = "artistIds")
    void updateEntityFromDto(AlbumDTO albumDTO, @MappingTarget Album album);
}