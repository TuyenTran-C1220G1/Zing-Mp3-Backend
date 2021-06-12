package com.example.zingmp3.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private String phone;

    private String avatar;

    private String address;

    private String email;

    private Long facebookId;

    @ManyToOne
    private Playlist playlistRoot;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;


}
