package com.example.zingmp3.service.playlist;

import com.example.zingmp3.model.Playlist;
import com.example.zingmp3.repository.IPlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
public class PlaylistServiceImpl implements IPlaylistService{
    @Autowired
    private IPlaylistRepository playlistRepository;

    @Override
    public List<Playlist> findAll(@RequestParam int page, @RequestParam int size) {
        return playlistRepository.findAll();
    }

    @Override
    public Optional<Playlist> findById(Long id) {
        return playlistRepository.findById(id);
    }

    @Override
    public Playlist save(Playlist playlist) {
        return playlistRepository.save(playlist);
    }

}
