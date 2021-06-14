package com.example.zingmp3.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nameSong;
    @Lob
    private String description;
    @Lob
    private String imageUrl;
    @Lob
    private String songUrl;

    private Date createAt;

    private Date editAt;

    private String album;
    //xoa
    private Boolean status = true;

    private Long likes = 0L;

    private Long views = 0L;

    private  String author;

    @ManyToOne
    private Artist artists;

    @ManyToOne
    private Genre genre ;


}
