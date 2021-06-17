package com.example.zingmp3.service.commentPlaylist;

import com.example.zingmp3.model.CommentPlayList;
import com.example.zingmp3.repository.ICommentPlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
public class CommentPlaylistServiceImpl implements ICommentPlaylistService {
    @Autowired
    ICommentPlaylistRepository commentPlaylistRepository;

    @Override
    public List<CommentPlayList> getAllByPlayListId(Long id,int page,int size) {
        return commentPlaylistRepository.getAllByPlayListId(id,page,size);
    }

    @Override
    public List<CommentPlayList> findAll(int page, int size) {
        return (List<CommentPlayList>) commentPlaylistRepository.findAll();
    }

    @Override
    public List<CommentPlayList> findAll() {
        return (List<CommentPlayList>) commentPlaylistRepository.findAll();
    }

    @Override
    public Optional<CommentPlayList> findById(Long id) {
        return commentPlaylistRepository.findById(id);
    }

    @Override
    public CommentPlayList save(CommentPlayList commentOfPlayList) {
        return commentPlaylistRepository.save(commentOfPlayList);
    }

    @Override
    public void delete(Long id) {
        commentPlaylistRepository.deleteById(id);
    }
}
