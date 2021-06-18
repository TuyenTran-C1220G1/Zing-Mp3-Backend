package com.example.zingmp3.controller;

import com.example.zingmp3.model.Playlist;
import com.example.zingmp3.model.Song;
import com.example.zingmp3.model.User;
import com.example.zingmp3.service.playlist.IPlaylistService;
import com.example.zingmp3.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
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

    @GetMapping("/list/")
    public ResponseEntity<?> getAllPlayList(@RequestParam int page, @RequestParam int size){
        List<Playlist> playlists = playlistService.findAll(page,size);
        if (playlists.size() == 0) {
            return new ResponseEntity<>("NO CONTENT", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(playlists, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Playlist> createPlaylist(@RequestBody Playlist playlist){
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

    @GetMapping("/myplaylists")
    public ResponseEntity<List<Playlist>> findAllByUserUsername() {
        return new ResponseEntity<>(playlistService.playListOfUser(), HttpStatus.OK);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Playlist> editPlaylist(@PathVariable Long id, @RequestBody Playlist playList) {
        Optional<Playlist> playlistOptional = playlistService.findById(id);
        if(playList.getImage().isEmpty()){
            playList.setImage(playlistOptional.get().getImage());
        }
        playList.setEditAt(Date.valueOf(LocalDate.now()));
        return playlistOptional.map(playlist -> {
            playList.setId(playList.getId());
            playlistService.save(playList);
            return new ResponseEntity<>(playList, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }



    @GetMapping( "/detail/{id}")
    public ResponseEntity<?> detail(@PathVariable Long id) {
        Optional<Playlist> playList = playlistService.findById(id);
        return new ResponseEntity<>(playList, HttpStatus.OK);
    }

    @GetMapping( "{id}")
    public ResponseEntity<?> deletePlaylist(@PathVariable Long id) {
        Optional<Playlist> playList = playlistService.findById(id);
        if (playList.isPresent()) {
            playList.get().setStatus(false);
            playlistService.save(playList.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}/songs")
    public ResponseEntity<List<Song>> getAllSongById(@PathVariable Long id) {
        Optional<Playlist> playlist = playlistService.findById(id);
        if(playlist.isPresent()){
            List<Song> songs=playlist.get().getSongs();
            return new ResponseEntity<>(songs, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/myPlaylist")
    public ResponseEntity<List<Playlist>> findAllByUser() {
        User currentUser= userService.getCurrentUser();
        List<Playlist> playlists = playlistService.findAllByUser(currentUser,true);
        return new ResponseEntity<>(playlists, HttpStatus.OK);
    }
}



