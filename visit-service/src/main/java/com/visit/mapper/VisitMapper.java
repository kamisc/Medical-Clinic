package com.visit.mapper;

import com.visit.domain.Visit;
import com.visit.dto.VisitDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Author Kamil Seweryn
 */

@Component
public class VisitMapper {
    public VisitDto mapToVisitDto(final Visit visit) {
        VisitDto visitDto = new VisitDto(
                visit.getDate(),
                visit.getDescription(),
                visit.getUserId(),
                visit.getDoctorId()
        );
        visitDto.setId(visit.getId());
        return visitDto;
    }

    public Visit mapToVisit(final VisitDto visitDto) {
        Visit visit = new Visit(
                visitDto.getDate(),
                visitDto.getDescription(),
                visitDto.getUserId(),
                visitDto.getDoctorId()
        );
        visit.setId(visitDto.getId());
        return visit;
    }

    public List<VisitDto> mapToVisitDtoList(final List<Visit> visitList) {
        return visitList.stream()
                .map(visit -> new VisitDto(
                        visit.getId(),
                        visit.getDate(),
                        visit.getDescription(),
                        visit.getUserId(),
                        visit.getDoctorId()))
                .collect(Collectors.toList());
    }
}