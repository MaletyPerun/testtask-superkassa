package com.example.superkassa.repository;

import com.example.superkassa.model.EventEntity;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface EventRepository extends JpaRepository<EventEntity, Integer> {
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    default EventEntity getExisted(int id) {
        return findById(id).orElseThrow(() -> new BadRequestException("Entity with id=" + id + " not found"));
    }
}
