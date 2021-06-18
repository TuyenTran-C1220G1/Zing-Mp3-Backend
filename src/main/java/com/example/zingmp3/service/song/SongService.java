package com.example.zingmp3.service.song;

import com.example.zingmp3.model.Playlist;
import com.example.zingmp3.model.Song;
import com.example.zingmp3.model.User;
import com.example.zingmp3.repository.ISongRepository;
import com.example.zingmp3.service.playlist.IPlaylistService;
import com.example.zingmp3.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class SongService implements ISongService {
    @Autowired
    ISongRepository iSongRepository;

    @Autowired
    UserService userService;

    @Autowired
    IPlaylistService playlistService;

    @Override
    public Page<Song> findAllByStatus(boolean status, Pageable pageable) {
        return iSongRepository.findAllSongByStatusOrderByIdDesc(status, pageable);
    }

    @Override
    public Song save(Song song) {
        return iSongRepository.save(song);
    }

    @Override
    public void remove(Long id) {
        iSongRepository.deleteById(id);
    }

    @Override
    public Optional<Song> findById(Long id) {
        return iSongRepository.findById(id);
    }

    @Override
    public List<Song> sortByLike(boolean status) {
        return iSongRepository.findSongByStatusOrderByLikesDesc(status);
    }

    @Override
    public List<Song> sortByDate(boolean status) {
        return iSongRepository.findSongByStatusOrderByCreateAtDesc(status);
    }

    @Override
    public List<Song> songOfUser() {
        User currentUser = userService.getCurrentUser();
        Optional<Playlist> playlistRoot = playlistService.findById(currentUser.getPlaylistRootId());
        List<Song> songs = new ArrayList<>();
        if (playlistRoot.isPresent()) {
            for (Song song : playlistRoot.get().getSongs()) {
                if (song.getStatus().equals(true)) {
                    songs.add(song);
                    Collections.sort(songs, new Comparator<Song>() {
                        @Override
                        public int compare(Song o1, Song o2) {
                            return o2.getId() > o1.getId() ? 1 : -1;
                        }
                    });
                }
            }
            return songs;
        }
        return null;
    }
}
