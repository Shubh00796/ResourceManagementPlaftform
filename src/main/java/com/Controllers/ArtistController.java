package com.Controllers;

import com.DTOS.ArtistDTO;
import com.Services.ArtistService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/artists")
@RequiredArgsConstructor
public class ArtistController {
    private final ArtistService artistService;

    @GetMapping
    public ResponseEntity<List<ArtistDTO>> getAllArtists() {
        return ResponseEntity.ok(artistService.getAllArtists());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArtistDTO> getArtistById(@PathVariable Long id) {
        return ResponseEntity.ok(artistService.getArtistById(id));
    }

    @PostMapping
    public ResponseEntity<ArtistDTO> createArtist(@RequestBody ArtistDTO artistDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(artistService.createArtist(artistDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ArtistDTO> updateArtist(@PathVariable Long id, @RequestBody ArtistDTO artistDTO) {
        artistDTO.setId(id);
        return ResponseEntity.ok(artistService.updateArtist(artistDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArtist(@PathVariable Long id) {
        artistService.deleteArtist(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/albumIds")
    public ResponseEntity<List<ArtistDTO>> findArtistsByAlbumIds(@RequestParam("albumIds") List<Long> albumIds) {
        return ResponseEntity.ok(artistService.findArtistsByAlbumIds(albumIds));
    }

    @GetMapping("/songIds")
    public ResponseEntity<List<ArtistDTO>> findArtistsBySongIds(@RequestParam("songIds") List<Long> songIds) {
        return ResponseEntity.ok(artistService.findArtistsBySongIds(songIds));
    }
}