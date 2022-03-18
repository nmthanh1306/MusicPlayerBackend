package com.is1423.musicplayerbackend.controller;

import java.util.List;
import java.util.Map;
import javax.validation.constraints.Positive;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.is1423.musicplayerbackend.model.response.SongResponseDTO;
import com.is1423.musicplayerbackend.service.SongService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@AllArgsConstructor
@RequestMapping("/api/song")
@Slf4j
public class SongController {

    private final SongService service;

    @GetMapping(value = {"/favourite", "/favourite/"})
    public ResponseEntity<List<SongResponseDTO>> getTop5FavoriteSong(@RequestParam(name = "userId", required = false) Long userId) {
        log.debug("--- execute method getTop5FavoriteSong: Start ---");
        List<SongResponseDTO> result = service.getListFavouriteSong(userId);
        log.debug("--- execute method getTop5FavoriteSong: End ---");
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = {"/playlist/{id}", "/playlist/{id}/"})
    public ResponseEntity<List<SongResponseDTO>> getSongByPlayList(@PathVariable @Positive Long id,
        @RequestParam(name = "userId", required = false) Long userId) {
        log.debug("--- execute method getSongByPlayList: Start ---");
        List<SongResponseDTO> result = service.getByPlayListId(id, userId);
        log.debug("--- execute method getSongByPlayList: End ---");
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = {"/type/{id}", "/type/{id}/"})
    public ResponseEntity<List<SongResponseDTO>> getSongByType(@PathVariable @Positive Long id,
        @RequestParam(name = "userId", required = false) Long userId) {
        log.debug("--- execute method getSongByType: Start ---");
        List<SongResponseDTO> result = service.getByTypeId(id, userId);
        log.debug("--- execute method getSongByType: End ---");
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = {"/album/{id}", "/album/{id}/"})
    public ResponseEntity<List<SongResponseDTO>> getSongByAlbum(@PathVariable @Positive Long id,
        @RequestParam(name = "userId", required = false) Long userId) {
        log.debug("--- execute method getSongByAlbum: Start ---");
        List<SongResponseDTO> result = service.getByAlbumId(id, userId);
        log.debug("--- execute method getSongByAlbum: End ---");
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = {"/search", "/search/"})
    public ResponseEntity<List<SongResponseDTO>> getSongByNameOrAuthor(
        @RequestParam(name = "name", required = false) String name,  @RequestParam(name = "userId", required = false) Long userId) {
        log.debug("--- execute method getSongByNameOrAuthor: Start ---");
        List<SongResponseDTO> result = service.getSongByNameOrAuthor(name, userId);
        log.debug("--- execute method getSongByNameOrAuthor: End ---");
        return ResponseEntity.ok(result);
    }

    @PutMapping(value = {"/favourite/{id}", "/favourite/{id}/"})
    public ResponseEntity<Map<String, Boolean>> updateSongFavourite(@PathVariable @Positive Long id, @RequestParam(name = "userId") Long userId) {
        log.debug("--- execute method updateSongFavourite: Start ---");
         Map<String, Boolean> result = service.updateFavouriteSong(id, userId);
        log.debug("--- execute method updateSongFavourite: End ---");
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = {"/favourite/user", "/favourite/user/"})
    public ResponseEntity<List<SongResponseDTO>> getSongFavourite(@RequestParam(name = "userId") Long userId) {
        log.debug("--- execute method getSongFavourite: Start ---");
        List<SongResponseDTO> result = service.getListSongFavourite(userId);
        log.debug("--- execute method getSongFavourite: End ---");
        return ResponseEntity.ok(result);
    }


    @PutMapping(value = {"/playlist/{id}", "/playlist/{id}/"})
    public ResponseEntity<Void> updateSongPlaylist(@PathVariable @Positive Long id, @RequestParam(name = "userId") Long userId) {
        log.debug("--- execute method updateSongPlaylist: Start ---");
        service.addUserPlayList(id, userId);
        log.debug("--- execute method updateSongPlaylist: End ---");
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = {"/playlist/{id}", "/playlist/{id}/"})
    public ResponseEntity<List<SongResponseDTO>> removeSongPlaylist(@PathVariable @Positive Long id,
        @RequestParam(name = "userId") Long userId) {
        log.debug("--- execute method removeSongPlaylist: Start ---");
        List<SongResponseDTO> result = service.removeSongFromPlayList(id, userId);
        log.debug("--- execute method removeSongPlaylist: End ---");
        return ResponseEntity.ok(result);
    }


}
