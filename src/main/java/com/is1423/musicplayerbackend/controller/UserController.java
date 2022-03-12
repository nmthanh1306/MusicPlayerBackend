package com.is1423.musicplayerbackend.controller;

import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.is1423.musicplayerbackend.model.response.UserResponseDTO;
import com.is1423.musicplayerbackend.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@AllArgsConstructor
@RequestMapping("/api/user")
@Slf4j
public class UserController {

    private UserService service;

    @PostMapping(value = {"/create", "/create/"})
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody @Valid UserResponseDTO userResponseDTO) {
        log.debug("--- excute method createUser: Start ---");
        UserResponseDTO result = service.createUser(userResponseDTO);
        log.debug("--- excute method createUser: End ---");
        return ResponseEntity.ok(result);
    }


    @PostMapping(value = {"/authenticate", "/authenticate/"})
    public ResponseEntity<UserResponseDTO> login(@RequestBody @Valid UserResponseDTO userResponseDTO) {
        log.debug("--- excute method login: Start ---");
        UserResponseDTO result = service.login(userResponseDTO);
        log.debug("--- excute method login: End ---");
        return ResponseEntity.ok(result);
    }

}
