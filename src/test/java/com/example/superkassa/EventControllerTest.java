package com.example.superkassa;

import com.example.superkassa.controller.EventController;
import com.example.superkassa.dto.EventEntityDto;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RequiredArgsConstructor
class EventControllerTest {

    @Autowired
    public final EventController controller;

    @Autowired
    public final TestRestTemplate restTemplate;

    @Test
    public void getTeapot() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        EventEntityDto dto = new EventEntityDto(2, 5);
//        MessageTo mes = new MessageTo("user", "Lorem ipsum");
        ResponseEntity<String> response = restTemplate.exchange("/modify", HttpMethod.POST, new HttpEntity<>(dto, headers), String.class);
        assertEquals(HttpStatus.I_AM_A_TEAPOT, response.getStatusCode());
    }

    public void update() {}



}
