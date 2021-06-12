package com.example.zingmp3.service.song;

import com.example.zingmp3.model.Song;
import com.example.zingmp3.model.User;
import com.example.zingmp3.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.awt.print.Pageable;

public interface ISongService {
    Iterable<Song> findAll();

    Song save(Song song);

    void remove(Long id) ;
}
