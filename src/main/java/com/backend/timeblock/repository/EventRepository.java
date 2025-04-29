package com.backend.timeblock.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.timeblock.model.Event;
import com.backend.timeblock.model.Priority;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    // This interface extends JpaRepository to provide CRUD operations for the Event entity
    // The first parameter is the entity tythe necpe (Event), and the second parameter is the type of the entity's ID (Long)
    // No additional methods are needed here, as JpaRepository provides all essary methods for basic CRUD operations

    List<Event> findByTitleAndEventDate(String title, LocalDate eventDate); 
    List<Event> findByPriority(Priority priority);
}
