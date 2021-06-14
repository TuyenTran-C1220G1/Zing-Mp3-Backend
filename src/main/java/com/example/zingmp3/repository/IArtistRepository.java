package com.example.zingmp3.repository;

import com.example.zingmp3.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IArtistRepository extends JpaRepository<Artist,Long> {
}
