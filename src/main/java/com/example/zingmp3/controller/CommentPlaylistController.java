package com.example.zingmp3.controller;

import com.example.zingmp3.model.CommentPlayList;
import com.example.zingmp3.model.User;
import com.example.zingmp3.service.commentPlaylist.ICommentPlaylistService;
import com.example.zingmp3.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/commentPlaylists")
@CrossOrigin("*")
public class CommentPlaylistController {
    @Autowired
    ICommentPlaylistService commentPlayListService;

    @Autowired
    IUserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<List<CommentPlayList>> showAllComment(@PathVariable Long id){
        List<CommentPlayList> commentOfPlayList = commentPlayListService.getAllByPlayListId(id);
        return new ResponseEntity<>(commentOfPlayList, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<List<CommentPlayList>>postComment(@RequestBody CommentPlayList commentPlayList){
        return new ResponseEntity(commentPlayListService.save(commentPlayList),HttpStatus.CREATED);
    }

}
