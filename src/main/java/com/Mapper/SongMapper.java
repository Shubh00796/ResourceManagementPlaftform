package com.Mapper;

import com.DTOS.SongDTO;
import com.Domian.Song;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface SongMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "title", source = "title")
    @Mapping(target = "duration", source = "duration")
    @Mapping(target = "albumId", source = "albumId")
    @Mapping(target = "artistIds", source = "artistIds")
    SongDTO toDto(Song song);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "title", source = "title")
    @Mapping(target = "duration", source = "duration")
    @Mapping(target = "albumId", source = "albumId")
    @Mapping(target = "artistIds", source = "artistIds")
    Song toEntity(SongDTO songDTO);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "title", source = "title")
    @Mapping(target = "duration", source = "duration")
    @Mapping(target = "albumId", source = "albumId")
    @Mapping(target = "artistIds", source = "artistIds")
    void updateEntityFromDto(SongDTO songDTO, @MappingTarget Song song);
}