package com.example.zingmp3.repository;

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
public interface ISongRepository extends JpaRepository<Song, Long> {
    Page<Song> findAllSongByStatus(Boolean status,Pageable pageable);

    @Query(value = "select * from song order by likes desc limit 6", nativeQuery = true)
    List<Song> findSongByStatusOrderByLikesDesc(Boolean status);

    @Query(value = "select * from song order by views desc limit 5", nativeQuery = true)
    List<Song> findSongByStatusOrderByViewsDesc(Boolean status);

    @Query(value = "select * from song order by id desc limit 10", nativeQuery = true)
    List<Song> findSongByStatusOrderByCreateAtDesc(Boolean status);
}
