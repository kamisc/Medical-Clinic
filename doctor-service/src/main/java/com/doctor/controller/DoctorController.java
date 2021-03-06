package com.doctor.controller;

import com.doctor.domain.exception.DoctorExistException;
import com.doctor.domain.exception.DoctorNotExistException;
import com.doctor.domain.exception.SpecializationNotExistException;
import com.doctor.dto.DoctorDto;
import com.doctor.mapper.DoctorMapper;
import com.doctor.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Author Kamil Seweryn
 */

@RestController
@CrossOrigin("*")
@RequestMapping
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
    public DoctorDto getDoctorById(@PathVariable Long id) throws DoctorNotExistException {
        return doctorMapper.mapToDoctorDto(doctorService.findDoctorById(id));
    }

    @GetMapping("/surname/{surname}")
    public DoctorDto getDoctorBySurname(@PathVariable String surname) throws DoctorNotExistException {
        return doctorMapper.mapToDoctorDto(doctorService.findDoctorBySurname(surname));
    }

    @GetMapping("/exist/{surname}")
    public boolean isDoctorExist(@PathVariable String surname) {
        return doctorService.isDoctorExist(surname);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void createDoctor(@RequestBody DoctorDto doctorDto) throws DoctorExistException {
        doctorService.createDoctor(doctorMapper.mapToDoctor(doctorDto));
    }

    @PutMapping(name = "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
    public DoctorDto updateDoctor(@RequestBody DoctorDto doctorDto) {
        return doctorMapper.mapToDoctorDto(doctorService.updateDoctor(doctorMapper.mapToDoctor(doctorDto)));
    }

    @PutMapping("/add")
    public DoctorDto addSpecializationToDoctor(@RequestParam Long doctorId, @RequestParam Long specializationId) throws DoctorNotExistException, SpecializationNotExistException {
        return doctorMapper.mapToDoctorDto(doctorService.updateDoctor(doctorService.addSpecializationToDoctor(doctorId, specializationId)));
    }

    @DeleteMapping
    public void deleteDoctor(@RequestParam Long id) throws DoctorNotExistException {
        doctorService.deleteDoctor(doctorService.findDoctorById(id));
    }
}