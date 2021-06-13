package com.example.zingmp3.controller;

import com.example.zingmp3.model.Playlist;
import com.example.zingmp3.model.Song;
import com.example.zingmp3.model.User;
import com.example.zingmp3.repository.ISongRepository;
import com.example.zingmp3.service.playlist.IPlaylistService;
import com.example.zingmp3.service.song.ISongService;
import com.example.zingmp3.service.user.IUserService;
import com.example.zingmp3.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/songs")
public class SongController {
    @Autowired
    ISongService songService;

    @Autowired
    UserService userService;

    @Autowired
    IPlaylistService playlistService;

    @GetMapping
    public ResponseEntity<?> getAllSong(Pageable pageable) {
        boolean status = true;
        return new ResponseEntity<>(songService.findAllByStatus(status, pageable), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createSong(@RequestBody Song song) {
        User currentUser = userService.getCurrentUser();
        List<Playlist> myPlaylist = playlistService.findAll();
        for (Playlist playlistRoot : myPlaylist) {
            if (playlistRoot.getId() == currentUser.getPlaylistRootId()) {
                song.getPlaylists().add(playlistRoot);
                return new ResponseEntity<>(songService.save(song), HttpStatus.OK);
            }
        }
        String mes = "lỗi vkl";
        return new ResponseEntity<>(mes, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<?> deleteSong(@PathVariable Long id) {
        Optional<Song> songOptional = songService.findById(id);
       if (songOptional!= null){
           songOptional.get().setStatus(false);
           songService.save(songOptional.get());
           return new ResponseEntity<>(HttpStatus.OK);
       }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Song> updateProduct(@PathVariable Long id, @RequestBody Song song) {
        Optional<Song> songOptional = songService.findById(id);
        return songOptional.map(song1 -> {
            song.setId(song1.getId());
            song.setPlaylists(song1.getPlaylists());
            songService.save(song);
            return new ResponseEntity<>(song, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
