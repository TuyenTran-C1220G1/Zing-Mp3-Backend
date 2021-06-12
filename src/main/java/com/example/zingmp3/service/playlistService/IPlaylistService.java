package com.example.zingmp3.service.playlistService;

import com.example.zingmp3.model.Playlist;
import com.example.zingmp3.service.IGeneralService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
public interface IPlaylistService {
    List<Playlist> findAll(@RequestParam int page, @RequestParam int size);

    Optional<Playlist> findById(Long id);

    Playlist save(Playlist playlist);

    void delete(Long id);

}
