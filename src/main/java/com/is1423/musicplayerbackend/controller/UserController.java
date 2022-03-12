package com.is1423.musicplayerbackend.controller;

import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.is1423.musicplayerbackend.model.response.UserDTO;
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
    public ResponseEntity<UserDTO> createUser(@RequestBody @Valid UserDTO userDTO) {
        log.debug("--- excute method createUser: Start ---");
        UserDTO result = service.createUser(userDTO);
        log.debug("--- excute method createUser: End ---");
        return ResponseEntity.ok(result);
    }


    @PostMapping(value = {"/authenticate", "/authenticate/"})
    public ResponseEntity<UserDTO> login(@RequestBody @Valid UserDTO userDTO) {
        log.debug("--- excute method login: Start ---");
        UserDTO result = service.login(userDTO);
        log.debug("--- excute method login: End ---");
        return ResponseEntity.ok(result);
    }

}
