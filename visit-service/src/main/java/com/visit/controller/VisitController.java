package com.visit.controller;

import com.visit.domain.exception.VisitNotExistException;
import com.visit.dto.VisitDto;
import com.visit.mapper.VisitMapper;
import com.visit.service.VisitService;
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
@RequestMapping(value = "/visits")
public class VisitController {
    private VisitService visitService;
    private VisitMapper visitMapper;

    @Autowired
    public VisitController(VisitService visitService, VisitMapper visitMapper) {
        this.visitService = visitService;
        this.visitMapper = visitMapper;
    }

    @GetMapping("/user/{userId}")
    public List<VisitDto> getAllVisitsByUserId(@PathVariable Long userId) {
        return visitMapper.mapToVisitDtoList(visitService.findAllVisitsByUserId(userId));
    }

    @GetMapping("/doctor/{doctorId}")
    public List<VisitDto> getAllVisitsByDoctorId(@PathVariable Long doctorId) {
        return visitMapper.mapToVisitDtoList(visitService.findAllVisitsByDoctorId(doctorId));
    }

    @GetMapping("/{id}")
    public VisitDto getVisitById(@PathVariable Long id) throws VisitNotExistException {
        return visitMapper.mapToVisitDto(visitService.findVisitById(id));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void createVisit(@RequestBody VisitDto visitDto) {
        visitService.createVisit(visitMapper.mapToVisit(visitDto));
    }

    @DeleteMapping
    public void deleteVisit(@RequestParam Long id) throws VisitNotExistException {
        visitService.deleteVisit(visitService.findVisitById(id));
    }
}