package com.example.zingmp3.repository;

import com.example.zingmp3.model.Song;
import com.example.zingmp3.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISongRepository extends JpaRepository<Song, Long> {
    Page<Song> findProductsByShop(Song shop);
}
