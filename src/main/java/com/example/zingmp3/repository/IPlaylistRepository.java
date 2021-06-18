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
import java.util.Optional;

@Repository
public interface IPlaylistRepository extends JpaRepository<Playlist,Long> {
    Page<Playlist> findAllSongByStatus(Boolean status, Pageable pageable);

    @Query(value = "select * from playlist order by create_at desc limit 5", nativeQuery = true)
    List<Playlist> findAllByCreatedTimeOrderByCreatedTime(boolean status);

    List<Playlist> findAllByUserUsername(String username);

    @Query(value = "select * from playlist order by views desc limit 5", nativeQuery = true)
    List<Playlist> findAllByViewsOrderByViews(boolean status);

//    @Query(value = "select * from playlist where user_id =?", nativeQuery = true)
    List<Playlist> findPlaylistByUserId(Long id);

    Playlist findPlaylistById(Long id);

    List<Playlist> findPlaylistByUserAndStatus(User user, Boolean status);


}
