package com.example.zingmp3.service.commentPlaylist;

import com.example.zingmp3.model.CommentPlayList;
import com.example.zingmp3.service.IGeneralService;
import com.example.zingmp3.service.genre.IGenreService;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

public interface ICommentPlaylistService extends IGeneralService<CommentPlayList> {
    List<CommentPlayList> getAllByPlayListId (Long id,int page,int size);
    List<CommentPlayList> findAll(int page,int size);

}
