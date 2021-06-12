package com.example.zingmp3.service.song;

import com.example.zingmp3.model.Song;
import com.example.zingmp3.repository.ISongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;


@Service
public class SongService implements ISongService {
    @Autowired
    ISongRepository iSongRepository;


    @Override
    public Iterable<Song> findAll() {
        return iSongRepository.findAll();
    }

    @Override
    public Song save(Song product) {
        return iSongRepository.save(product);
    }

    @Override
    public void remove(Long id) {
        iSongRepository.deleteById(id);
    }
}
