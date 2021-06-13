package com.example.zingmp3.service.playlist;

import com.example.zingmp3.model.Playlist;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;


public interface IPlaylistService {
    List<Playlist> findAll(@RequestParam int page, @RequestParam int size);

    Optional<Playlist> findById(Long id);

    Playlist save(Playlist playlist);

    List<Playlist> findAll();

}
