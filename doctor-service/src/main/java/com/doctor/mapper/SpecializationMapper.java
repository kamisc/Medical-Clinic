package com.doctor.mapper;

import com.doctor.domain.Specialization;
import com.doctor.dto.SpecializationDto;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Author Kamil Seweryn
 */

public class SpecializationMapper {
    public SpecializationDto mapToSpecializationDto(final Specialization specialization) {
        return new SpecializationDto(
                specialization.getId(),
                specialization.getName(),
                specialization.getDoctors()
        );
    }

    public Specialization mapToSpecialization(final SpecializationDto specializationDto) {
        return new Specialization(specializationDto.getName());
    }

    public List<SpecializationDto> mapToSpecializationDtoList(final List<Specialization> specializations) {
        return specializations.stream()
                .map(specialization -> new SpecializationDto(
                        specialization.getId(),
                        specialization.getName(),
                        specialization.getDoctors()))
                .collect(Collectors.toList());
    }
}