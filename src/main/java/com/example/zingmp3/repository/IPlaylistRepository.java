package com.example.zingmp3.repository;

import com.example.zingmp3.model.Playlist;
import com.example.zingmp3.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IPlaylistRepository extends JpaRepository<Playlist,Long> {
    Page<Playlist> findAllSongByStatus(Boolean status, Pageable pageable);

    @Query(value = "select * from playlist where status=true order by create_at desc limit 5", nativeQuery = true)
    List<Playlist> findAllByCreatedTimeOrderByCreatedTime(boolean status);

    @Query(value = "select * from playlist order by views desc limit 5", nativeQuery = true)
    List<Playlist> findAllByViewsOrderByViews(boolean status);

        @Query(value = "select * from playlist where status=true order by user desc id", nativeQuery = true)
    List<Playlist> findPlaylistByUserId(Long id);

    Playlist findPlaylistById(Long id);




}