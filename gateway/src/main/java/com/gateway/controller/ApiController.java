package com.gateway.controller;

import com.gateway.client.DoctorServiceClient;
import com.gateway.client.UserServiceClient;
import com.gateway.client.VisitServiceClient;
import com.gateway.dto.DoctorDto;
import com.gateway.dto.UserDto;
import com.gateway.dto.VisitDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Author Kamil Seweryn
 */

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class ApiController {

    private UserServiceClient userServiceClient;
    private DoctorServiceClient doctorServiceClient;
    private VisitServiceClient visitServiceClient;

    @Autowired
    public ApiController(
            UserServiceClient userServiceClient,
            DoctorServiceClient doctorServiceClient,
            VisitServiceClient visitServiceClient) {
        this.userServiceClient = userServiceClient;
        this.doctorServiceClient = doctorServiceClient;
        this.visitServiceClient = visitServiceClient;
    }

    @GetMapping("/user-visits/{userId}")
    public UserDto getVisitsForOneUser(@PathVariable Long userId) {
        UserDto userDto = userServiceClient.getOneUser(userId);
        List<VisitDto> visitDtoList = visitServiceClient.getVistisForOneUser(userId);

        userDto.getVisitDtoList().addAll(visitDtoList);

        return userDto;
    }

    @GetMapping("/doctor-visits/{doctorId}")
    public DoctorDto getOneDoctor(@PathVariable Long doctorId) {
        DoctorDto doctorDto = doctorServiceClient.getOneDoctor(doctorId);
        List<VisitDto> visitDtoList = visitServiceClient.getVistisForOneDoctor(doctorId);

        doctorDto.getVisitDtoList().addAll(visitDtoList);

        return doctorDto;
    }
}