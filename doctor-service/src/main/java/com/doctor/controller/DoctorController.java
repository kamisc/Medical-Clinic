package com.doctor.controller;

import com.doctor.domain.Doctor;
import com.doctor.domain.Specialization;
import com.doctor.domain.exception.DoctorExistException;
import com.doctor.domain.exception.DoctorNotExistException;
import com.doctor.dto.DoctorDto;
import com.doctor.mapper.DoctorMapper;
import com.doctor.service.DoctorService;
import com.doctor.service.SpecializationService;
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
    private SpecializationService specializationService;

    @Autowired
    public DoctorController(DoctorService doctorService, DoctorMapper doctorMapper, SpecializationService specializationService) {
        this.doctorService = doctorService;
        this.doctorMapper = doctorMapper;
        this.specializationService = specializationService;
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
    public void createDoctor(@RequestBody DoctorDto doctorDto) throws DoctorExistException {
        doctorService.createDoctor(doctorMapper.mapToDoctor(doctorDto));
    }

    @PutMapping(name = "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
    public DoctorDto updateDoctor(@RequestBody DoctorDto doctorDto) {
        return doctorMapper.mapToDoctorDto(doctorService.updateDoctor(doctorMapper.mapToDoctor(doctorDto)));
    }

    /*@PutMapping("/add/")
    public DoctorDto addSpecializationToDoctor(@RequestParam Long doctorId, @RequestParam Long specializationId) throws DoctorNotExistException {
        Specialization specialization = specializationService.findSpecializationById(specializationId);
        Doctor doctor = doctorService.findDoctorById(doctorId);
        doctor.getSpecializations().add(specialization);
        return doctorMapper.mapToDoctorDto(doctorService.updateDoctor(doctor));
    }*/

    @PutMapping("/add/")
    public DoctorDto addSpecializationToDoctor(@RequestParam Long doctorId, @RequestParam Long specializationId) throws DoctorNotExistException {
        return doctorMapper.mapToDoctorDto(doctorService.updateDoctor(doctorService.addSpecializationToDoctor(doctorId, specializationId)));
    }

    @DeleteMapping
    public void deleteDoctor(@RequestParam Long id) throws DoctorNotExistException {
        doctorService.deleteDoctor(doctorService.findDoctorById(id));
    }
}