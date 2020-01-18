package com.doctor.controller;

import com.doctor.dto.DoctorDto;
import com.doctor.mapper.DoctorMapper;
import com.doctor.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Author Kamil Seweryn
 */

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/doctors")
public class DoctorController {
    private DoctorService doctorService;
    private DoctorMapper doctorMapper;

    @Autowired
    public DoctorController(DoctorService doctorService, DoctorMapper doctorMapper) {
        this.doctorService = doctorService;
        this.doctorMapper = doctorMapper;
    }

    @GetMapping
    public List<DoctorDto> getAllDoctors() {
        return doctorMapper.mapToDoctorDtoList(doctorService.findAllDoctors());
    }

    @GetMapping("/id/{id}")
    public DoctorDto getDoctorById(@PathVariable Long id) {
        return doctorMapper.mapToDoctorDto(doctorService.findDoctorById(id));
    }

    @GetMapping("/surname/{surname}")
    public DoctorDto getDoctorBySurname(@PathVariable String surname) {
        return doctorMapper.mapToDoctorDto(doctorService.findDoctorBySurname(surname));
    }

    @GetMapping("/exist/{surname}")
    public boolean isDoctorExist(@PathVariable String surname) {
        return doctorService.isDoctorExist(surname);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createDoctor(@RequestBody DoctorDto doctorDto) {
        doctorService.createDoctor(doctorMapper.mapToDoctor(doctorDto));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public DoctorDto updateDoctor(@RequestBody DoctorDto doctorDto) {
        return doctorMapper.mapToDoctorDto(doctorService.updateDoctor(doctorMapper.mapToDoctor(doctorDto)));
    }

    @DeleteMapping
    public void deleteDoctor(@RequestParam Long id) {
        doctorService.deleteDoctor(doctorService.findDoctorById(id));
    }
}