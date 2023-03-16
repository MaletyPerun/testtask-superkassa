package com.example.superkassa.service;

import com.example.superkassa.dto.EventEntityDto;
import com.example.superkassa.model.EventEntity;
import com.example.superkassa.model.ObjJson;
import com.example.superkassa.repository.BadRequestException;
import com.example.superkassa.repository.EventRepository;
import org.aspectj.lang.annotation.Before;
import org.h2.tools.Server;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.SQLException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EventServiceTest {

    // TODO: 16.03.2023 test (1)
    @Configuration
    public static class AppConfig {

        @Profile("dev")
        @Bean(initMethod = "start", destroyMethod = "stop")
        Server h2Server() throws SQLException {
            return Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "9092");
        }
    }

    // TODO: 16.03.2023 check test on MockBean (2)
    @MockBean
    EventRepository repository;

    @Autowired
    EventService service;

    @BeforeAll
    public void setUp() {
        // TODO: 16.03.2023 check test on H2 (1)
//        Employee alex = new Employee("alex");
//
//        EventEntityDto eventEntityDto = new EventEntityDto(1, 0);
//        ObjJson obj = new ObjJson();
//        obj.setCurrent(0L);
//        Mockito.when(repository.findById(eventEntityDto.getId()))
//                .thenReturn(Optional.of(new EventEntity(1L, obj)));


//        repository.save(eventEntityDto);
    }

    @Test
    void saveEntity() {
        // TODO: 16.03.2023 all for test (2)
        ObjJson objJson = new ObjJson();
        objJson.setCurrent(0L);
        EventEntity entity = new EventEntity(1L, objJson);
        Mockito.when(repository.getExisted(1)).thenReturn(entity);
        EventEntityDto eventDto = new EventEntityDto(1, 5);
        ObjJson obj = service.saveEntity(eventDto);
        assertEquals(5L, obj.getCurrent());
    }

    @Test
    void notFound() {
        EventEntityDto eventDto = new EventEntityDto(2, 5);
        assertThrows(BadRequestException.class, ()-> service.saveEntity(eventDto));
    }
}