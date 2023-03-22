package com.example.superkassa.controller;

import com.example.superkassa.dto.EventEntityDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EventControllerTest {

    @Autowired
    public TestRestTemplate restTemplate;

    @Test
    void getTeapot() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        EventEntityDto dto = new EventEntityDto(2, 5);
        ResponseEntity<String> response = restTemplate.exchange("/modify", HttpMethod.POST, new HttpEntity<>(dto, headers), String.class);
        assertEquals(HttpStatus.I_AM_A_TEAPOT, response.getStatusCode());
    }

    @Test
    void update() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        EventEntityDto dto = new EventEntityDto(1, 5);
        ResponseEntity<String> response = restTemplate.exchange("/modify", HttpMethod.POST, new HttpEntity<>(dto, headers), String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("{\"current\":5}", response.getBody());
    }
}
