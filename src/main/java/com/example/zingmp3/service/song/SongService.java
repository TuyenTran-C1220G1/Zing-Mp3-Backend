package com.example.zingmp3.service.song;

import com.example.zingmp3.model.Song;
import com.example.zingmp3.repository.ISongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class SongService implements ISongService {
    @Autowired
    ISongRepository iSongRepository;


    @Override
    public Page<Song> findAllByStatus(Boolean status, Pageable pageable) {
        return iSongRepository.findAllSongByStatus(status,pageable);
    }


    @Override
    public Song save(Song song) {
        return iSongRepository.save(song);
    }

    @Override
    public void remove(Long id) {
        iSongRepository.deleteById(id);
    }

    @Override
    public Optional<Song> findById(Long id) {
        return iSongRepository.findById(id);
    }

    @Override
    public List<Song> sortByLike(Boolean status) {

        return iSongRepository.findSongByStatusOrderByLikesDesc(status);
    }

    @Override
    public List<Song> sortByView(Boolean status) {
        return iSongRepository.findSongByStatusOrderByViewsDesc(status);
    }


}
