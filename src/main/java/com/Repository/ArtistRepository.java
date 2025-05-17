package com.Repository;

import com.Domian.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {


    @Query("SELECT a FROM Artist a WHERE a.albumIds IN :albumIds")
    List<Artist> findByAlbumIds(@Param("albumIds") List<Long> albumIds);

    @Query(value = "SELECT * FROM artist WHERE JSON_CONTAINS(songIds, :songIds, '$[*]')", nativeQuery = true)
    List<Artist> findABySongIds(@Param("songIds") List<Long> songIds);
}