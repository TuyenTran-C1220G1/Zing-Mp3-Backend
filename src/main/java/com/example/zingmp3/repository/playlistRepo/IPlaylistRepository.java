package com.example.zingmp3.repository.playlistRepo;

import com.example.zingmp3.model.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPlaylistRepository extends JpaRepository<Playlist,Long> {

}
