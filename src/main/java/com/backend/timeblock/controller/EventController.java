package com.backend.timeblock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.timeblock.model.Event;
import com.backend.timeblock.model.Priority;
import com.backend.timeblock.services.EventService;
import java.util.Optional;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/events")
@Slf4j

// This is the controller class for handling event-related requests
// It uses Spring's RestController and RequestMapping annotations to define the base URL for the controller
public class EventController {
    @Autowired
    private EventService eventService;

    //Method to add an event
    @PostMapping("/add")
   public ResponseEntity<Event> addEvent(@RequestBody Event event){
    log.info("Adding new event: {}",event.getTitle());
    return ResponseEntity.ok(eventService.addEvent(event));
   }

   //Method to update an event
    @PutMapping("/update/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable Long id, @RequestBody Event event) {
        log.info("Updating event with ID: {}", id);
        Event updatedEvent = eventService.updateEvent(id, event);
        if (updatedEvent ==null){
            log.warn("Event not found with ID: {}", id);
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedEvent);
    }

    //Method to delete an event
     @DeleteMapping("/delete/{id}")
     public ResponseEntity<String> deleteEvent(@PathVariable Long id) {
        log.info("Deleting event with ID: {}", id);
        if (eventService.listEvents().isEmpty()) {
            log.warn("No events found to delete");
            return ResponseEntity.noContent().build();
        }
        eventService.deleteEvent(id);
      return ResponseEntity.ok("Event deleted successfully");
     }

     //Method to get an event
    @GetMapping
    public ResponseEntity<List<Event>> getAllEvents() {
        List<Event> events = eventService.listEvents();
        log.info("Fetching all events, total count: {}", events.size());
        if(events.isEmpty()) {
            log.warn("No evnts found");
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(events);
    }
    @GetMapping("/priority/{priority}")
    public ResponseEntity<List<Event>> getEventByPriority(@PathVariable Priority priority){
        return ResponseEntity.ok(eventService.getEventByPriority(priority));
    }
    @GetMapping("/{id}")
public ResponseEntity<Event> getEventsById(@PathVariable Long id) {
    Optional<Event> event = eventService.listEvents().stream()
        .filter(e -> e.getId().equals(id))
        .findFirst();
    
    return event.map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.notFound().build());
}
}
