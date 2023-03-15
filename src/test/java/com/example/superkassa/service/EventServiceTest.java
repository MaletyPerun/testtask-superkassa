package com.example.superkassa.service;

import com.example.superkassa.model.ObjJson;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static com.example.superkassa.service.EventServiceTestData.EVENT_DTO;
import static com.example.superkassa.service.EventServiceTestData.EXPECTED_OBJ_JSON;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RequiredArgsConstructor
class EventServiceTest {

    @Autowired
    private final EventService service;

    @Test
    void updateWithoutControllLock() {
        ObjJson testObj = service.saveEntity(EVENT_DTO);
        assertEquals(EXPECTED_OBJ_JSON, testObj);
    }
}