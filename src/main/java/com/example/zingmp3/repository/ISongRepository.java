package com.example.zingmp3.repository;

import com.example.zingmp3.model.Song;
import com.example.zingmp3.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ISongRepository extends JpaRepository<Song, Long> {
    Page<Song> findAllSongByStatus(Boolean status,Pageable pageable);

}
