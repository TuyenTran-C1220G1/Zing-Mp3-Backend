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
    public ResponseEntity<List<CommentPlayList>> showAllComment(@PathVariable Long id,@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size){
        List<CommentPlayList> commentOfPlayList = commentPlayListService.getAllByPlayListId(id,page,size);
        return new ResponseEntity<>(commentOfPlayList, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<List<CommentPlayList>>postComment(@RequestBody CommentPlayList commentPlayList){
        return new ResponseEntity(commentPlayListService.save(commentPlayList),HttpStatus.CREATED);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?>updateComment(@RequestBody CommentPlayList commentPlayList, @PathVariable Long id){
        String mes = "Lỗi";
        String mess = "Thành công";
        commentPlayList.setId(id);
        Optional<CommentPlayList> commentPlayList1 = commentPlayListService.findById(id);
        User user = userService.getCurrentUser();
        String username = user.getUsername();
        boolean us = username.equalsIgnoreCase(commentPlayList1.get().getUser().getUsername());
        if (us){
            commentPlayList.setUser(commentPlayList1.get().getUser());
            commentPlayList.setPlaylist(commentPlayList1.get().getPlaylist());
            commentPlayListService.save(commentPlayList);
            return new ResponseEntity<>(mess,HttpStatus.OK);
        }else {
            return new ResponseEntity<>(mes, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>deleteComment(@PathVariable Long id){
        Optional<CommentPlayList> commentPlayList = commentPlayListService.findById(id);
        User user = userService.getCurrentUser();
        String username = user.getUsername();
        boolean us = username.equalsIgnoreCase(commentPlayList.get().getUser().getUsername());
        if (us){
            commentPlayListService.delete(id);
            String mess = "Thành công";
            return new ResponseEntity<>(mess,HttpStatus.OK);
        }else {
            String mes = "Lỗi";
            return new ResponseEntity<>(mes,HttpStatus.NOT_FOUND);
        }

    }
}
