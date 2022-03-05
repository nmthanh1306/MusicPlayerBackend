package com.is1423.MusicPlayerBackend.controller;

import com.is1423.MusicPlayerBackend.model.response.AdvertisementResponseDto;
import com.is1423.MusicPlayerBackend.service.AdvertisementService;
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
    public ResponseEntity<?> getAllAdvertisements(){
        List<AdvertisementResponseDto> advertisements = service.getAllAdvertisements();
        return ResponseEntity.ok(advertisements);
    }
}
