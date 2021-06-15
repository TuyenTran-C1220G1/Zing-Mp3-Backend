package com.example.zingmp3.controller;

import com.example.zingmp3.model.Genre;
import com.example.zingmp3.repository.IGenreRepository;
import com.example.zingmp3.service.genre.IGenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/genres")
public class GenreController {


    @Autowired
    IGenreService genreService;

    @GetMapping("{id}")
    ResponseEntity<?> getGenreById(@PathVariable Long id){
        return new ResponseEntity<>(genreService.findById(id), HttpStatus.OK);
    }

    @GetMapping("list")
    ResponseEntity<?> getAll(){
        return new ResponseEntity<>(genreService.findAll(),HttpStatus.OK);
    }
}
