package com.example.springboot.event.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.event.model.Event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.springboot.event.services.EventService;
import java.util.Date;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(path = "/event")
public class EventController {

    @Autowired
    EventService eventService;

    @GetMapping(path = "/getAll")
    public List<Event> getAllEvents() {
        return eventService.findAll();
    }

    @PostMapping(path = "/newEvent")
    public Event newEvent(@RequestBody Event event) {
        if (event.getDescription() == null || event.getTitle() == null || event.getTime() == null) {
            return null;
        } else {
            return eventService.save(event);
        }

    }

    @GetMapping(path = "/getById")
    public Event getEventById(@RequestParam("id") Long id) {
        return eventService.findById(id).get();
    }

    @PostMapping(path = "/updateEvent")
    public boolean updateEvent(@RequestParam("id") Long id) {
        Event event = eventService.findById(id).get();
        event.setTitle("Updated Title");
        event.setDescription("Updated Description");
        event.setTime(new Date());
        eventService.save(event);
        return true;

    }

}
