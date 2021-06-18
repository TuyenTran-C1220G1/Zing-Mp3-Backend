package com.example.zingmp3.service.commentPlaylist;

import com.example.zingmp3.model.CommentPlayList;
import com.example.zingmp3.model.Playlist;
import com.example.zingmp3.model.User;
import com.example.zingmp3.repository.ICommentPlaylistRepository;
import com.example.zingmp3.service.playlist.IPlaylistService;
import com.example.zingmp3.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
public class CommentPlaylistServiceImpl implements ICommentPlaylistService {
    @Autowired
    ICommentPlaylistRepository commentPlaylistRepository;

    @Autowired
    IUserService userService;

    @Autowired
    IPlaylistService playlistService;


    @Override
    public List<CommentPlayList> getAllByPlayListId(Long id) {
        return commentPlaylistRepository.getAllByPlayListId(id);
    }

    @Override
    public List<CommentPlayList> findAll(int page, int size) {
        return null;
    }

    @Override
    public List<CommentPlayList> findAll() {
        return null;
    }

    @Override
    public Optional<CommentPlayList> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public CommentPlayList save(CommentPlayList commentOfPlayList) {
//        User user = userService.getCurrentUser();
//        List<Playlist> playlist = playlistService.findPlaylistByUserId(user.getId());
//        commentOfPlayList.setUser(user);
//        commentOfPlayList.setPlaylist((Playlist) playlist);
//        return commentPlaylistRepository.save(commentOfPlayList);
        return null;
    }

    @Override
    public void delete(Long id) {
        commentPlaylistRepository.deleteById(id);
    }
}
