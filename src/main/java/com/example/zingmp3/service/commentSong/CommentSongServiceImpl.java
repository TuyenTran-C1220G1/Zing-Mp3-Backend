package com.example.zingmp3.service.commentSong;

import com.example.zingmp3.model.CommentSong;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentSongServiceImpl implements ICommentSongService{
    @Override
    public List<CommentSong> getAllBySongId(Long id, int page, int size) {
        return null;
    }

    @Override
    public List<CommentSong> findAll(int page, int size) {
        return null;
    }

    @Override
    public List<CommentSong> findAll() {
        return null;
    }

    @Override
    public Optional<CommentSong> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public CommentSong save(CommentSong commentSong) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
