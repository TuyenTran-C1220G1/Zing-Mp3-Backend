package com.example.zingmp3.controller;

import com.example.zingmp3.model.User;
import com.example.zingmp3.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class UserController {

    @Autowired
    private IUserService userService;

    @PutMapping("/users")
    public ResponseEntity<?> edit(@RequestBody User editUser) {
        User currentUser= userService.getCurrentUser();

        currentUser.setEmail(editUser.getEmail());
        userService.save(currentUser);
        return new ResponseEntity<>(currentUser, HttpStatus.OK);

    }
}
