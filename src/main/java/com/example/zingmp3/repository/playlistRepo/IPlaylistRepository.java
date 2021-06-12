package com.example.zingmp3.repository.playlistRepo;

import com.example.zingmp3.model.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPlaylistRepository extends JpaRepository<Playlist,Long> {

}
