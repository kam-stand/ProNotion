package com.spring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.dto.Eventdto;
import com.spring.model.Event;
import com.spring.repository.EventRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/event")
public class EventController {

    @Autowired
    private EventRepository eventRepository;

    @PostMapping("/create")
    public ResponseEntity<?> postEvent(@RequestBody Eventdto eventdto) {
        try {
            // create event
            Event event = new Event(eventdto.getName(), eventdto.getPriority());
            eventRepository.save(event);
            return ResponseEntity.ok("Event created successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error creating event");
        }
    }

}
