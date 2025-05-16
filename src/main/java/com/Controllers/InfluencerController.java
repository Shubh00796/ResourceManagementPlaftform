package com.Controllers;


import com.DTOS.InfluencerDTO;
import com.Services.InfluencerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/influencers")
@RequiredArgsConstructor
public class InfluencerController {

    private final InfluencerService influencerService;

    @GetMapping
    public ResponseEntity<List<InfluencerDTO>> getAllInfluencers() {
        List<InfluencerDTO> influencers = influencerService.getAllInfluencers();
        return ResponseEntity.ok(influencers);
    }

    @GetMapping("/social-media-platform/{socialMediaPlatform}")
    public ResponseEntity<List<InfluencerDTO>> getBySocialMediaPlatform(@PathVariable String socialMediaPlatform) {
        List<InfluencerDTO> influencers = influencerService.getBySocialMediaPlatform(socialMediaPlatform);
        return ResponseEntity.ok(influencers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InfluencerDTO> getInfluencerById(@PathVariable Long id) {
        InfluencerDTO influencer = influencerService.getInfluencerById(id);
        return ResponseEntity.ok(influencer);
    }

    @PostMapping
    public ResponseEntity<InfluencerDTO> createInfluencer(@RequestBody @Valid InfluencerDTO influencer) {
        InfluencerDTO createdInfluencer = influencerService.createInfluencer(influencer);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdInfluencer);
    }

    @PutMapping
    public ResponseEntity<InfluencerDTO> updateInfluencer(@RequestBody @Valid InfluencerDTO influencer) {
        InfluencerDTO updatedInfluencer = influencerService.updateInfluencer(influencer);
        return ResponseEntity.ok(updatedInfluencer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInfluencer(@PathVariable Long id) {
        influencerService.deleteInfluencer(id);
        return ResponseEntity.noContent().build();
    }
}