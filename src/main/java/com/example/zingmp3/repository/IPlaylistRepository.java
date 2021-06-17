package com.example.zingmp3.repository;

import com.example.zingmp3.model.Playlist;
import com.example.zingmp3.model.Song;
import com.example.zingmp3.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPlaylistRepository extends JpaRepository<Playlist,Long> {
    Page<Playlist> findAllSongByStatus(Boolean status, Pageable pageable);

    @Query(value = "select * from playlist order by create_at desc limit 5", nativeQuery = true)
    List<Playlist> findAllByCreatedTimeOrderByCreatedTime();

    @Query(value = "select * from playlist order by views desc limit 5", nativeQuery = true)
    List<Playlist> findAllByViewsOrderByViews();


    List<Playlist> findAllByUserUsername(String username);

    List<Playlist> findPlaylistByUserAndStatus(User user, Boolean status);


}
