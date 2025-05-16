package com.Controllers;


import com.DTOS.OfferDTO;
import com.Services.OfferService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/offers")
@RequiredArgsConstructor
public class OfferController {

    private final OfferService offerService;

    @GetMapping
    public ResponseEntity<List<OfferDTO>> getAllOffers() {
        List<OfferDTO> offers = offerService.getAllOffers();
        return ResponseEntity.ok(offers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OfferDTO> getOfferById(@PathVariable Long id) {
        OfferDTO offer = offerService.getOfferById(id);
        return ResponseEntity.ok(offer);
    }

    @PostMapping
    public ResponseEntity<OfferDTO> createOffer(@RequestBody @Valid OfferDTO offer) {
        OfferDTO createdOffer = offerService.createOffer(offer);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdOffer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OfferDTO> updateOffer(@PathVariable Long id, @RequestBody @Valid OfferDTO offer) {
        // Note: Ensure the ID in the path matches the ID in the offer body
        offer.setId(id);
        OfferDTO updatedOffer = offerService.updateOffer(offer);
        return ResponseEntity.ok(updatedOffer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOffer(@PathVariable Long id) {
        offerService.deleteOffer(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/influencer/{influencerId}")
    public ResponseEntity<List<OfferDTO>> getOffersByInfluencerId(@PathVariable Long influencerId) {
        List<OfferDTO> offers = offerService.getOffersByInfluencerId(influencerId);
        return ResponseEntity.ok(offers);
    }

    @GetMapping("/brand/{brandId}")
    public ResponseEntity<List<OfferDTO>> getOffersByBrandId(@PathVariable Long brandId) {
        List<OfferDTO> offers = offerService.getOffersByBrandId(brandId);
        return ResponseEntity.ok(offers);
    }

    // Accept Offer Endpoint
    @PatchMapping("/accept/{id}")
    public ResponseEntity<OfferDTO> acceptOffer(@PathVariable Long id) {
        OfferDTO acceptedOffer = offerService.acceptOffer(id);
        return ResponseEntity.ok(acceptedOffer);
    }

    // Reject Offer Endpoint
    @PatchMapping("/reject/{id}")
    public ResponseEntity<OfferDTO> rejectOffer(@PathVariable Long id) {
        OfferDTO rejectedOffer = offerService.rejectOffer(id);
        return ResponseEntity.ok(rejectedOffer);
    }
}