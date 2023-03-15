package com.example.superkassa.controller;

import com.example.superkassa.dto.EventEntityDto;
import com.example.superkassa.model.ObjJson;
import com.example.superkassa.service.EventService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/modify")
public class EventController {

    @Autowired
    private final EventService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ObjJson> saveEntity(@RequestBody @Valid EventEntityDto entityDto) {
        return ResponseEntity.ok(service.saveEntity(entityDto));
    }

    @GetMapping
    public ResponseEntity<ObjJson> getEntity(@RequestParam int id) {
        return ResponseEntity.ok(service.getEntity(id));
    }
}
