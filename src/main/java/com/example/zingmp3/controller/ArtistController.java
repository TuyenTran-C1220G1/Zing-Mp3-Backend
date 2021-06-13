package com.example.zingmp3.controller;

import com.example.zingmp3.model.Artist;
import com.example.zingmp3.model.Playlist;
import com.example.zingmp3.model.User;
import com.example.zingmp3.service.artist.IArtistService;
import com.example.zingmp3.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/artists")
public class ArtistController {
    @Autowired
    IArtistService artistService;

    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<?> getAll(){
        List<Artist> artists = artistService.findAll();
        if (artists.size() == 0) {
            return new ResponseEntity<>("NO CONTENT", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(artists, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<Artist> artist = artistService.findById(id);
        if (!artist.isPresent()) {
            return new ResponseEntity<>("NO CONTENT", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(artist, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Artist> createArtist(@RequestBody Artist artist){
        User currentUser= userService.getCurrentUser();
        return new ResponseEntity<>(artistService.save(artist),HttpStatus.OK);
    }
}
