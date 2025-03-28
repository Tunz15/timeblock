package com.backend.timeblock.repository;

import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.timeblock.model.Event;

public interface EventRepository extends JpaRepository<Event, Short> {
    // This interface extends JpaRepository to provide CRUD operations for the Event entity
    // The first parameter is the entity tythe necpe (Event), and the second parameter is the type of the entity's ID (Short)
    // No additional methods are needed here, as JpaRepository provides all essary methods for basic CRUD operations

    List<Event> findById(Long id); // Custom query method to find events by ID
    List<Event> findByTitle(String title); // Custom query method to find events by title
    List<Event> findByTitleAndTime(String title, LocalTime time); // Custom query method to find events by title and time range

}
