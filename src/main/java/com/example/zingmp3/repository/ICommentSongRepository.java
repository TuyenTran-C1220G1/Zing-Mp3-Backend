package com.example.zingmp3.repository;

import com.example.zingmp3.model.CommentPlayList;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICommentSongRepository {
    @Query(value = "select * from comment_song where song_id = ?;", nativeQuery = true)
    List<CommentPlayList> getAllComment(Long id, int page, int size);
}
