package com.example.zingmp3.repository;

import com.example.zingmp3.model.CommentPlayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ICommentPlaylistRepository extends CrudRepository<CommentPlayList, Long> {
    @Query(value = "select * from comment_play_list where playlist_id = ?;", nativeQuery = true)
    List<CommentPlayList> getAllByPlayListId(Long id,int page,int size);

}
