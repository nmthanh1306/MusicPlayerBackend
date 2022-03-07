package com.is1423.musicplayerbackend.controller;

import com.is1423.musicplayerbackend.model.response.AdvertisementResponseDTO;
import com.is1423.musicplayerbackend.service.AdvertisementService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/advertisement")
public class AdvertisementController {

    private final AdvertisementService service;

    @GetMapping("/get-all-advertisements")
    public ResponseEntity<List<AdvertisementResponseDTO>> getAllAdvertisements(){
        return ResponseEntity.ok(service.getAllAdvertisements());
    }
}
