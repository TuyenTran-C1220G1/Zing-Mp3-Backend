package com.example.zingmp3.service.playlistService;

import com.example.zingmp3.model.Playlist;
import com.example.zingmp3.repository.playlistRepo.IPlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
@Service
public class PlaylistServiceImpl implements IPlaylistService{
    @Autowired
    private IPlaylistRepository playlistRepository;

    public List<Playlist> findAll(@RequestParam int page, @RequestParam int size) {
        return playlistRepository.findAll();
    }

    public Optional<Playlist> findById(Long id) {
        return Optional.empty();
    }


    public Playlist save(Playlist playlist) {
        return playlistRepository.save(playlist);
    }

    public void delete(Long id) {
        playlistRepository.deleteById(id);
    }
}
