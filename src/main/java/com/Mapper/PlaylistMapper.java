package com.Mapper;

import com.DTOS.PlaylistDTO;
import com.Domian.Playlist;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PlaylistMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "songIds", source = "songIds")
    PlaylistDTO toDto(Playlist playlist);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "songIds", source = "songIds")
    Playlist toEntity(PlaylistDTO playlistDTO);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "songIds", source = "songIds")
    void updateEntityFromDto(PlaylistDTO playlistDTO, @MappingTarget Playlist playlist);
}