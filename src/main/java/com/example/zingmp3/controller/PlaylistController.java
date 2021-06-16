package com.example.zingmp3.controller;

import com.example.zingmp3.model.Playlist;
import com.example.zingmp3.model.User;
import com.example.zingmp3.service.playlist.IPlaylistService;
import com.example.zingmp3.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/playlists")
public class PlaylistController {

    @Autowired
    UserService userService;


    @Autowired
    IPlaylistService playlistService;

    @GetMapping("/list")
    public ResponseEntity<?> getAllPlayList(@RequestParam int page, @RequestParam int size){
        List<Playlist> playlists = playlistService.findAll(page,size);
        if (playlists.size() == 0) {
            return new ResponseEntity<>("NO CONTENT", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(playlists, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Playlist> createPlaylist(@RequestBody Playlist playlist){
        User currentUser= userService.getCurrentUser();
        playlist.setUser(currentUser);
        return new ResponseEntity<>(playlistService.save(playlist),HttpStatus.CREATED);
    }

    @GetMapping(value = "/news",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Playlist>> getAllRatingsPlaylist(){
        return new ResponseEntity<>(playlistService.findAllByCreatedTimeOrderByCreatedTime(),HttpStatus.OK);
    }

    @GetMapping("/user/{idPlaylist}/songs/{idSong}")
    public ResponseEntity<Playlist> addSongToPlaylist(@PathVariable("idPlaylist") Long idPlaylist, @PathVariable("idSong") Long idSong) {
        return new ResponseEntity<>(playlistService.addSongToPlaylist(idSong, idPlaylist), HttpStatus.OK);
    }

    @GetMapping(value = "/topview", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Playlist>> getAllTopView(){
        return new ResponseEntity<>(playlistService.findAllByViewsOrderByViews(),HttpStatus.OK);
    }

    @GetMapping("/user/{username}")
    public ResponseEntity<List<Playlist>> findAllByUserUsername(@PathVariable String username) {
        List<Playlist> playlists = playlistService.findAllByUserUsername(username);
        return new ResponseEntity<>(playlists, HttpStatus.OK);
    }

    @GetMapping("/user/{username}/{id}")
    public ResponseEntity<?> getPlayListById(@PathVariable Long id) {
        Optional<Playlist> playList = playlistService.findById(id);
        if (!playList.isPresent()) {
            System.out.println("Playlist with id : " + id + "not found");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(playList, HttpStatus.OK);
        }
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Playlist> editPlaylist(@PathVariable Long id, @RequestBody Playlist playList) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        playList.setEditAt(timestamp);
        playList.setId(id);
        if (playList.getId() == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            playlistService.save(playList);
            return new ResponseEntity<>(playList, HttpStatus.OK);
        }
    }

    @PutMapping("/user/edit/{username}/{id}")
    public ResponseEntity<Playlist> updatePlayListByUser(@PathVariable String username, @RequestBody Playlist playList, @PathVariable Long id) {
        if (!playlistService.findById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            User user = userService.findByUsername(username);
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            playList.setEditAt(timestamp);
            playList.setUser(user);
            playlistService.save(playList);
            return new ResponseEntity<>(playList, HttpStatus.OK);
        }
    }

}
