package com.doctor.mapper;

import com.doctor.domain.Doctor;
import com.doctor.domain.Specialization;
import com.doctor.dto.DoctorDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Author Kamil Seweryn
 */

@Component
public class DoctorMapper {
    public DoctorDto mapToDoctorDto(final Doctor doctor) {
        Set<Specialization> specializations = doctor.getSpecializations();

        DoctorDto doctorDto = new DoctorDto(
                doctor.getName(),
                doctor.getSurname(),
                specializations
        );
        doctorDto.setId(doctor.getId());
        return doctorDto;
    }

    public Doctor mapToDoctor(final DoctorDto doctorDto) {
        Doctor doctor = new Doctor(
                doctorDto.getName(),
                doctorDto.getSurname()
                //doctorDto.getSpecializations()
        );
        doctor.setId(doctorDto.getId());
        return doctor;
    }

    public List<DoctorDto> mapToDoctorDtoList(final List<Doctor> doctorList) {
        return doctorList.stream()
                .map(doctor -> new DoctorDto(
                        doctor.getId(),
                        doctor.getName(),
                        doctor.getSurname(),
                        doctor.getSpecializations()))
                .collect(Collectors.toList());
    }
}