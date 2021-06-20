package com.example.zingmp3.service.song;

import com.example.zingmp3.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ISongService {
    Page<Song> findAllByStatus(boolean status, Pageable pageable);

    Song save(Song song);

    void remove(Long id);

    Optional<Song> findById(Long id);

    List<Song> sortByLike(boolean status);

    List<Song> sortByDate(boolean status);

    List<Song> songOfUser();

    List<Song> findAllByStatusAndNameSongContains(boolean status, String nameSong);
}
