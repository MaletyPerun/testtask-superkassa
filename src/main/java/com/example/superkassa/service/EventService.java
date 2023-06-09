package com.example.superkassa.service;

import com.example.superkassa.dto.EventEntityDto;
import com.example.superkassa.model.EventEntity;
import com.example.superkassa.model.ObjJson;
import com.example.superkassa.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class EventService {

    private final EventRepository repository;

    public ObjJson saveEntity(EventEntityDto eventDto) {

        int id = eventDto.getId();
        int add = eventDto.getAdd();

        EventEntity entity = repository.getExisted(id);
        ObjJson obj = entity.getObj();
        long current = obj.getCurrent();

        obj.setCurrent(current + add);
        entity.setObj(obj);

        return repository.save(entity).getObj();
    }
}
