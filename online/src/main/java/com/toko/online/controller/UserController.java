package com.toko.online.controller;

import com.toko.online.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public ResponseEntity getUser() {
        var getUserData = userService.getUser();
//        var user = new UserService();
        return ResponseEntity.ok(getUserData);
    }
}
