package com.is1423.musicplayerbackend.controller;

import java.util.List;
import javax.validation.constraints.Positive;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.is1423.musicplayerbackend.model.response.AdvertisementResponseDTO;
import com.is1423.musicplayerbackend.model.response.SongResponseDTO;
import com.is1423.musicplayerbackend.service.AdvertisementService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@AllArgsConstructor
@RequestMapping("/api/advertisement")
@Slf4j
public class AdvertisementController {

    private final AdvertisementService service;

    @GetMapping("/get-all-advertisements")
    public ResponseEntity<List<AdvertisementResponseDTO>> getAllAdvertisements() {
        log.debug("--- execute method getAllAdvertisements: Start ---");
        List<AdvertisementResponseDTO> result = service.getAllAdvertisements();
        log.debug("--- execute method getAllAdvertisements: End ---");
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{adversitementId}")
    public ResponseEntity<SongResponseDTO> getSongByAdvertisement(@PathVariable @Positive Long adversitementId) {
        log.debug("--- execute method getSongByAdvertisement: Start ---");
        SongResponseDTO result = service.getSongByAdvertisement(adversitementId);
        log.debug("--- execute method getSongByAdvertisement: End ---");
        return ResponseEntity.ok(result);
    }

}
