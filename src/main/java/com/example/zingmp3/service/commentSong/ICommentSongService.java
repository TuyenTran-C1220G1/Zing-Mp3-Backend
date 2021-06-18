package com.example.zingmp3.service.commentSong;

import com.example.zingmp3.model.CommentPlayList;
import com.example.zingmp3.model.CommentSong;
import com.example.zingmp3.service.IGeneralService;

import java.util.List;

public interface ICommentSongService extends IGeneralService<CommentSong> {
    List<CommentSong> getAllBySongId (Long id, int page, int size);
    List<CommentSong> findAll(int page,int size);

}
