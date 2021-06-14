package com.example.zingmp3.controller;

import com.example.zingmp3.model.Playlist;
import com.example.zingmp3.model.User;
import com.example.zingmp3.service.playlist.IPlaylistService;
import com.example.zingmp3.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/playlists")
public class PlaylistController {

    @Autowired
    UserService userService;


    @Autowired
    IPlaylistService playlistService;

    @GetMapping
    public ResponseEntity<?> getAllPlayList(@RequestParam int page, @RequestParam int size){
        List<Playlist> playlists = playlistService.findAll(page,size);
        if (playlists.size() == 0) {
            return new ResponseEntity<>("NO CONTENT", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(playlists, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Playlist> createPlaylist(@RequestBody Playlist playlist){
        User currentUser= userService.getCurrentUser();
        playlist.setUser(currentUser);
        return new ResponseEntity<>(playlistService.save(playlist),HttpStatus.CREATED);
    }

    @GetMapping("/ratings")
    public ResponseEntity<List<Playlist>> getAllRatingsPlaylist(){
        return new ResponseEntity<List<Playlist>>(playlistService.findAllByCreatedTimeOrderByCreatedTime(),HttpStatus.OK);
    }

    @GetMapping("/user/{idPlaylist}/songs/{idSong}")
    public ResponseEntity<Playlist> addSongToPlaylist(@PathVariable("idPlaylist") Long idPlaylist, @PathVariable("idSong") Long idSong) {
        return new ResponseEntity<>(playlistService.addSongToPlaylist(idSong, idPlaylist), HttpStatus.OK);
    }

}
