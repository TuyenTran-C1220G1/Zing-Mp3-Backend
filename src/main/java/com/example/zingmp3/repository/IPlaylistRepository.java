package com.example.zingmp3.repository;

import com.example.zingmp3.model.Playlist;
import com.example.zingmp3.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IPlaylistRepository extends JpaRepository<Playlist,Long> {
    Page<Playlist> findAllSongByStatus(boolean status, Pageable pageable);

    // lay ra top 5 bai hat moi nhat
    @Query(value = "select * from playlist where status = ? order by create_at desc limit 5", nativeQuery = true)
    List<Playlist> findAllByCreatedTimeOrderByCreatedTime(boolean status);


    List<Playlist> findAllByUserUsername(String username);

    // playlist nghe nhieu nhat
    @Query(value = "select * from playlist where status = ? order by views desc limit 5", nativeQuery = true)
    List<Playlist> findAllByViewsOrderByViews(boolean status);

//    @Query(value = "select * from playlist where user_id =?", nativeQuery = true)
    List<Playlist> findPlaylistByUserId(Long id);

    Page<Playlist> findAllByStatus(boolean status, Pageable pageable);


    List<Playlist> findPlaylistByUserAndStatus(User user, boolean status);


}
