package com.example.zingmp3.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Playlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String namePlaylist;

    @Lob
    private String description;

    private String type;

    private String image;

    private Date createAt;

    private Date editAt;

    private Boolean status;

    @ManyToOne
    private User user;

}
