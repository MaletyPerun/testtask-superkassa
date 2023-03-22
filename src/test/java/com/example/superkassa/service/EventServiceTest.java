package com.example.superkassa.service;

import com.example.superkassa.dto.EventEntityDto;
import com.example.superkassa.model.EventEntity;
import com.example.superkassa.model.ObjJson;
import com.example.superkassa.repository.EventRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EventServiceTest {

    @Mock
    public EventRepository repository;

    @InjectMocks
    public EventService service;

    @Test
    void update() {
        ObjJson obj = new ObjJson();
        obj.setCurrent(8L);
        EventEntityDto dto = new EventEntityDto(1, 12);
        EventEntity entity = new EventEntity(1L, obj);
        when(repository.getExisted(1)).thenReturn(entity);
        when(repository.save(Mockito.any(EventEntity.class)))
                .thenAnswer(i -> i.getArguments()[0]);
        ObjJson actual = service.saveEntity(dto);
        assertEquals(20L, actual.getCurrent());
    }
}
