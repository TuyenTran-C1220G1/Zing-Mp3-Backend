package com.example.zingmp3.controller;
import com.example.zingmp3.model.Playlist;
import com.example.zingmp3.model.Song;
import com.example.zingmp3.model.User;
import com.example.zingmp3.service.playlist.IPlaylistService;
import com.example.zingmp3.service.song.ISongService;
import com.example.zingmp3.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



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
    public ResponseEntity<Page<Song>> getAllSong(Pageable pageable) {
        boolean status = true;
        return new ResponseEntity<Page<Song>>(songService.findAllByStatus(status, pageable), HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Optional<Song>> getDetailSong(@PathVariable Long id) {
        return new ResponseEntity<Optional<Song>>(songService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/top")
    public ResponseEntity<?> getTopSong() {
        boolean status = true;
        return new ResponseEntity<>(songService.sortByLike(status), HttpStatus.OK);
    }

    @GetMapping("/new")
    public ResponseEntity<?> getNewSong() {
        boolean status = true;
        return new ResponseEntity<>(songService.sortByDate(status), HttpStatus.OK);
    }

    @GetMapping("/yoursongs")
    public ResponseEntity<?> songOfUser() {
        return new ResponseEntity<>(songService.songOfUser(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createSong(@RequestBody Song song) {
        java.util.Date createAt=new java.util.Date();
        song.setCreateAt(createAt);
        song.setStatus(true);
        User currentUser = userService.getCurrentUser();
//        song.setStatus(true);
        Optional<Playlist> playlistRoot = playlistService.findById(currentUser.getPlaylistRootId());
        if (playlistRoot.isPresent()) {
            playlistRoot.get().getSongs().add(song);
            return new ResponseEntity<>(songService.save(song), HttpStatus.OK);
        }
        String mes = "lỗi vkl";
        return new ResponseEntity<>(mes, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> deleteSong(@PathVariable Long id) {
        Optional<Song> songOptional = songService.findById(id);
        if (songOptional.isPresent()) {
            songOptional.get().setStatus(false);
            songService.save(songOptional.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Song> updateSong(@PathVariable Long id, @RequestBody Song song) {
        Optional<Song> songOptional = songService.findById(id);
        if(song.getImageUrl().isEmpty()){
            song.setImageUrl(songOptional.get().getImageUrl());
        }
        if(song.getSongUrl().isEmpty()){
            song.setSongUrl(songOptional.get().getImageUrl());
        }
        java.util.Date editAt=new java.util.Date();
        song.setEditAt(editAt);
        return songOptional.map(song1 -> {
            song.setId(song1.getId());
            songService.save(song);
            return new ResponseEntity<>(song, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}