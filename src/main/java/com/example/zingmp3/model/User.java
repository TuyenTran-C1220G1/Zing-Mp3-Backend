package com.example.zingmp3.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 6, max=20)
    @Column(unique = true, nullable = false)
    private String username;

    @NotBlank
    @Column(nullable = false)
    private String password;

    @NotBlank
    @Column(unique = true)
    @Size(min = 10, max=10)
    private String phone;

    private String avatar ;

    private String address;

    @Column(unique = true)
    private String email;

    private Long facebookId;

    @ManyToOne
    private Playlist playlistRoot;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;


}
