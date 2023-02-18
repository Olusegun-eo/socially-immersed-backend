package com.emmanueljohnsnbruna.Blackbrowncommunity.web;

import com.emmanueljohnsnbruna.Blackbrowncommunity.data.model.Event;
import com.emmanueljohnsnbruna.Blackbrowncommunity.service.EventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping
    public ResponseEntity<Event> createEvent(@RequestBody Event event) {
        Event createdEvent = eventService.createEvent(event);
        return ResponseEntity.created(URI.create("/api/events/" + createdEvent.getId()))
                .body(createdEvent);
    }

    @GetMapping(params = "hashtag")
    public ResponseEntity<List<Event>> searchEventsByHashtag(@RequestParam String hashtag) {
        List<Event> events = eventService.searchEventsByHashtag(hashtag);
        return ResponseEntity.ok(events);
    }
}