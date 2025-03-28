package com.backend.timeblock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.timeblock.model.Event;
import com.backend.timeblock.services.EventService;

@RestController
@RequestMapping("/api/v1/events")

// This is the controller class for handling event-related requests
// It uses Spring's RestController and RequestMapping annotations to define the base URL for the controller
public class EventController {
    @Autowired
    private EventService eventService;

    //Method to add an event
    @PostMapping("/add")
   public ResponseEntity<Event> addevent(@RequestBody Event event){
    return ResponseEntity.ok(eventService.addevent(event));
   }

    // @PutMapping("/update/{id}")
    // public ResponseEntity<Event> getEventById(@PathVariable Long id, @RequestBody Event event) {
    //     Event updatedEvent = eventService.updateEvent(id, event);
    //     return ResponseEntity.ok(EventUpdated);
    // }
    // @DeleteMapping("/delete/{id}")
    // public ResponseEntity<Void> deleteEvent(@PathVariable Long id, @RequestBody Event event) {
    //    eventService.deleteEvent(id, event);
    //     return ResponseEntity.ok(EventDeleted);
    // }
    // @GetMapping
    // public ResponseEntity<Event> getEventById(@PathVariable Long id, @RequestParam(required = false) String time) {
    //     Event event = eventService.getEventByTitle(id, time);
    //     return ResponseEntity.ok(event);
    //}
}
