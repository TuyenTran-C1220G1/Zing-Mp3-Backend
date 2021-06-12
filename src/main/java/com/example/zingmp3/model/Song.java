package com.example.zingmp3.model;

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

    private String description;

    private String imageUrl;

    private String songUrl;

    private Date createAt;

    private Date editAt;

    private String album;
    //xoa
    private Boolean status = true;

    private Long likes = 0L;

    private Long views = 0L;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Playlist> playlists = new ArrayList<>();
}
