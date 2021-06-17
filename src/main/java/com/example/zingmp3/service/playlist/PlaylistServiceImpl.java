package com.example.zingmp3.service.playlist;

import com.example.zingmp3.model.Playlist;
import com.example.zingmp3.model.Song;
import com.example.zingmp3.model.User;
import com.example.zingmp3.repository.IPlaylistRepository;
import com.example.zingmp3.repository.ISongRepository;
import com.example.zingmp3.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PlaylistServiceImpl implements IPlaylistService{
    @Autowired
    private IPlaylistRepository playlistRepository;

    @Autowired
    private ISongRepository songRepository;

    @Autowired
    private IUserService userService;
    @Override
    public List<Playlist> findAll(int page, int size) {
        PageRequest pageRequest =   PageRequest.of(page,size);
        return playlistRepository.findAll(pageRequest).getContent();
    }

    @Override
    public Optional<Playlist> findById(Long id) {
        return playlistRepository.findById(id);
    }

    @Override
    public Playlist findPlaylistById(Long id) {
        return playlistRepository.findPlaylistById(id);
    }

    @Override
    public List<Playlist> findPlaylistByUserId(Long id) {
        return playlistRepository.findPlaylistByUserId(id);
    }

    @Override
    public Playlist save(Playlist playlist) {
        Boolean status = true;
        Date date = new java.util.Date();
        User user = userService.getCurrentUser();
        playlist.setUser(user);
        playlist.setCreateAt(date);
        playlist.setStatus(status);
        return playlistRepository.save(playlist);
    }

    @Override
    public List<Playlist> findAll() {
        return playlistRepository.findAll();
    }

    @Override
    public Page<Playlist> findAllByStatus(Boolean status, Pageable pageable) {
        return playlistRepository.findAllSongByStatus(status,pageable);
    }

    @Override
    public List<Playlist> findAllByCreatedTimeOrderByCreatedTime() {
        Boolean status = true;
        return playlistRepository.findAllByCreatedTimeOrderByCreatedTime(status);
    }

    @Override
    public Playlist addSongToPlaylist(Long idSong, Long idPlaylist) {
        Song song = songRepository.findById(idSong).get();
        Playlist playlist = playlistRepository.findById(idPlaylist).get();
        List<Song> songs = playlist.getSongs();
        if (songs.contains(song)) {
            return null;
        }
        songs.add(song);
        playlist.setSongs(songs);
        playlistRepository.save(playlist);
        return playlist;
    }

    @Override
    public List<Playlist> findAllByViewsOrderByViews() {
        Boolean status = true;
        return playlistRepository.findAllByViewsOrderByViews(status);
    }

//    @Override
//    public Playlist edit(Playlist playlist) {
//        Date date = new java.util.Date();
//        Playlist playlist1 = findPlaylistById(playlist.getId());
//        playlist1.setEditAt(date);
//        playlist1.setNamePlaylist(playlist.getNamePlaylist());
//        playlist1.setDescription(playlist.getDescription());
//        playlist1.setType(playlist.getType());
//        playlist1.setImage(playlist.getImage());
//        return playlist1;
//    }


    @Override
    public List<Playlist> playListOfUser() {
        User currentUser = userService.getCurrentUser();
        List<Playlist> playlistOptional = findPlaylistByUserId(currentUser.getId());
        return playlistOptional;
    }


}