package com.doctor.controller;

import com.doctor.domain.exception.CantDeleteSpecializationException;
import com.doctor.domain.exception.SpecializationExistException;
import com.doctor.domain.exception.SpecializationNotExistException;
import com.doctor.dto.SpecializationDto;
import com.doctor.mapper.SpecializationMapper;
import com.doctor.service.SpecializationService;
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
@RequestMapping(value = "/specializations")
public class SpecializationController {
    private SpecializationService specializationService;
    private SpecializationMapper specializationMapper;

    @Autowired
    public SpecializationController(SpecializationService specializationService, SpecializationMapper specializationMapper) {
        this.specializationService = specializationService;
        this.specializationMapper = specializationMapper;
    }

    @GetMapping
    public List<SpecializationDto> getAllSpecializations() {
        return specializationMapper.mapToSpecializationDtoList(specializationService.findAllSpecializations());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void addSpecialization(@RequestBody SpecializationDto specializationDto) throws SpecializationExistException {
        specializationService.addSpecialization(specializationMapper.mapToSpecialization(specializationDto));
    }

    @DeleteMapping
    public void deleteSpecialization(@RequestParam Long id) throws CantDeleteSpecializationException, SpecializationNotExistException {
        specializationService.deleteSpecialization(specializationService.findSpecializationById(id));
    }
}