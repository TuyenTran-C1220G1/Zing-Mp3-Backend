package com.example.zingmp3.controller;

import com.example.zingmp3.model.Song;
import com.example.zingmp3.repository.ISongRepository;
import com.example.zingmp3.service.song.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/songs")
public class SongController {
    @Autowired
    ISongService songService;

    @GetMapping
    public ResponseEntity<Iterable<Song>> getAllSong() {
        return new ResponseEntity<>(songService.findAll(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Song> createSong(@RequestBody Song song) {
        return new ResponseEntity<>(songService.save(song), HttpStatus.OK);
    }


}
