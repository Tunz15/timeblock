package com.backend.timeblock.services;

import org.springframework.stereotype.Service;

import com.backend.timeblock.model.Event;
import com.backend.timeblock.repository.EventRepository;

@Service
public class EventService {
    private EventRepository eventRepository;
    public Event addevent(Event event) {
        return eventRepository.save(event);
    }

//  public Event updateEvent (Long id,Event updatedEvent) {
//   Event existingEvent = eventRepository.findById(id).orElseThrow(() -> new RuntimeException("Event not found"));
//   existingEvent,setTitle(updatedEvent.getTitle());
//   existingEvent.setDescription(updatedEvent.getDescription());
//   existingEvent.setPriority(updatedEvent.getPriority());
//   existingEvent.setEventTime(updatedEvent.getEventTime());
//   existingEvent.setEventDate(updatedEvent.getEventDate());
//   return eventRepository.save(existingEvent);
//  }
//  public void deleteEvent (Long id) {
//   eventRepository.deleteById(id);
//  }
//  public List<Event> listEvents(Long id, String time){
//   if (id !=null) {
//   LocalTime localTime = localTime.parse(time);
//   return eventRepository.findByIdAndTime(id, LocalTime.eventTime);
//  }
// }
}
