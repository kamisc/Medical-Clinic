package com.gateway.client;

import com.gateway.dto.DoctorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Author Kamil Seweryn
 */

@Component
public class DoctorServiceClient {

    private final RestTemplate restTemplate;

    @Autowired
    public DoctorServiceClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public DoctorDto getOneDoctor(final Long doctorId) {
        return restTemplate
                .getForObject(
                        "http://localhost:8080/doctors/doctors/id/" + doctorId,
                        DoctorDto.class);
    }
}