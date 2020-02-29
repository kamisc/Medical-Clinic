package com.gateway.controller;

import com.gateway.client.UserServiceClient;
import com.gateway.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Author Kamil Seweryn
 */

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class ApiController {

    private UserServiceClient userServiceClient;

    @Autowired
    public ApiController(UserServiceClient userServiceClient) {
        this.userServiceClient = userServiceClient;
    }

    @GetMapping("/{userId}")
    public UserDto getUser(@PathVariable Long userId) {
        return userServiceClient.getOneUser(userId);
    }
}