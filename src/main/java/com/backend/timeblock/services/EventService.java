package com.backend.timeblock.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.backend.timeblock.model.Event;
import com.backend.timeblock.model.Priority;
import com.backend.timeblock.repository.EventRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EventService {

    private final EventRepository eventRepository;
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Event addEvent(Event event) {
        try {
            return eventRepository.save(event);
        } catch (Exception e){
            log.error("Failed to add event: {}", event, e);
            throw new RuntimeException("Failed to save event");
        }
        
    }

    public Event updateEvent (Long id,Event updatedEvent) {
        Optional<Event> existingEvent = eventRepository.findById(id);
        if(existingEvent.isPresent()){
            Event event = existingEvent.get();
            event.setTitle(updatedEvent.getTitle());
            event.setDescription(updatedEvent.getDescription());
            event.setPriority(updatedEvent.getPriority());
            event.setEventTime(updatedEvent.getEventTime());
            event.setEventDate(updatedEvent.getEventDate());
            return eventRepository.save(event);
        }
        return null;
       
    }
    public void deleteEvent (Long id) {
        eventRepository.deleteById(id);
    }
    public List<Event> listEvents(){
        return eventRepository.findAll();
    }
    public List<Event> getEventByPriority(Priority priority){
        return eventRepository.findByPriority(priority);
    }

}
