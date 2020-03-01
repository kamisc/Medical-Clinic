package com.gateway.client;

import com.gateway.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Author Kamil Seweryn
 */

@Component
public class UserServiceClient {

    private final RestTemplate restTemplate;

    @Autowired
    public UserServiceClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public UserDto getOneUser(final Long userId) {
        return restTemplate
                .getForObject(
                        "http://localhost:8080/users/id/" + userId,
                        UserDto.class);
    }
}