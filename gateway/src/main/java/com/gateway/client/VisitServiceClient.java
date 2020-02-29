package com.gateway.client;

import com.gateway.dto.VisitDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Author Kamil Seweryn
 */

@Component
public class VisitServiceClient {

    private final RestTemplate restTemplate;

    private HttpHeaders headers = new HttpHeaders();

    @Autowired
    public VisitServiceClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<VisitDto> getVistisForOneUser(final Long userId) {
        VisitDto[] response = restTemplate.getForObject(
                "http://localhost:8080/visits/visits/user/" + userId,
                VisitDto[].class);
        return Stream.of(response).collect(Collectors.toList());
    }

    public List<VisitDto> getVistisForOneDoctor(final Long doctorId) {
        VisitDto[] response = restTemplate.getForObject(
                "http://localhost:8080/visits/visits/doctor/" + doctorId,
                VisitDto[].class);
        return Stream.of(response).collect(Collectors.toList());
    }
}