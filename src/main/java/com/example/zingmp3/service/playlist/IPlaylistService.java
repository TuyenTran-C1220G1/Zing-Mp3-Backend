package com.example.zingmp3.service.playlist;

import com.example.zingmp3.model.Playlist;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;


public interface IPlaylistService {
    List<Playlist> findAll(int page,int size);

    Optional<Playlist> findById(Long id);

    Playlist findPlaylistById(Long id);

    List<Playlist> findPlaylistByUserId(Long id);
    Playlist save(Playlist playlist);

    List<Playlist> findAll();

    Page<Playlist> findAllByStatus(Boolean status, Pageable pageable);

    List<Playlist> findAllByCreatedTimeOrderByCreatedTime();

    Playlist addSongToPlaylist(Long idSong, Long idPlaylist);

    List<Playlist> findAllByViewsOrderByViews();

//    Playlist edit(Playlist playlist);

    List<Playlist> playListOfUser();


}
