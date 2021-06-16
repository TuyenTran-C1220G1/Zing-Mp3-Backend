package com.example.zingmp3.service.song;

import com.example.zingmp3.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ISongService {
    Page<Song> findAllByStatus(Boolean status, Pageable pageable);

    Song save(Song song);

    void remove(Long id);

    Optional<Song> findById(Long id);

    List<Song> sortByLike(Boolean status);

    List<Song> sortByView(Boolean status);

    List<Song> songOfUser();
}
