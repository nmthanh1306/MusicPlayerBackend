package com.is1423.musicplayerbackend.controller;

import java.util.List;
import javax.validation.constraints.Positive;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.is1423.musicplayerbackend.model.response.TypeResponseDTO;
import com.is1423.musicplayerbackend.service.TypeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@AllArgsConstructor
@RequestMapping("/api/type")
@Slf4j
public class TypeController {

    private final TypeService service;

    @GetMapping(value = {"", "/"})
    public ResponseEntity<List<TypeResponseDTO>> get4TypeByDay() {
        log.debug("--- excute method get4TypeByDay: Start ---");
        List<TypeResponseDTO> result = service.getTypeRandom();
        log.debug("--- excute method get4TypeByDay: End ---");
        return ResponseEntity.ok(result);
    }


    @GetMapping(value = {"/{id}", "/{id}/"})
    public ResponseEntity<TypeResponseDTO> getDetail(@PathVariable @Positive Long id) {
        log.debug("--- excute method getDetail by type: Start ---");
        TypeResponseDTO result = service.getDetail(id);
        log.debug("--- excute method getDetail by type: End ---");
        return ResponseEntity.ok(result);
    }

}
