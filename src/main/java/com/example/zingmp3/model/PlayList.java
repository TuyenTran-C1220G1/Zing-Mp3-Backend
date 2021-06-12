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
public class PlayList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String namePlaylist;

    private String description;

    private String image;

    private Date createAt;

    private Date editAt;

    private Boolean status;

    @ManyToOne
    private User user;

}
