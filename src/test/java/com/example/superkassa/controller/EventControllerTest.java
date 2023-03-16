package com.example.superkassa.controller;

import com.example.superkassa.dto.EventEntityDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;

class EventControllerTest {

    @Autowired
    RestTemplate restTemplate;

    @Test
    void updateEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        EventEntityDto dto = new EventEntityDto(1, 5);
        ResponseEntity<String> request = restTemplate.exchange("/modify", HttpMethod.POST, new HttpEntity<>(dto, headers), String.class);
        assertEquals(HttpStatus.OK, request.getStatusCode());
    }

    @Test
    void notFound() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        EventEntityDto dto = new EventEntityDto(2, 5);
        ResponseEntity<String> request = restTemplate.exchange("/modify", HttpMethod.POST, new HttpEntity<>(dto, headers), String.class);
        assertEquals(HttpStatus.I_AM_A_TEAPOT, request.getStatusCode());
    }
}