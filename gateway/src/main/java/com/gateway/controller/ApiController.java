package com.gateway.controller;

import com.gateway.client.DoctorServiceClient;
import com.gateway.client.UserServiceClient;
import com.gateway.dto.DoctorDto;
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
    private DoctorServiceClient doctorServiceClient;

    @Autowired
    public ApiController(UserServiceClient userServiceClient, DoctorServiceClient doctorServiceClient) {
        this.userServiceClient = userServiceClient;
        this.doctorServiceClient = doctorServiceClient;
    }

    @GetMapping("/user/{userId}")
    public UserDto getOneUser(@PathVariable Long userId) {
        return userServiceClient.getOneUser(userId);
    }

    @GetMapping("/doctor/{doctorId}")
    public DoctorDto getOneDoctor(@PathVariable Long doctorId) {
        return doctorServiceClient.getOneDoctor(doctorId);
    }
}