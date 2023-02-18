package com.emmanueljohnsnbruna.Blackbrowncommunity.service;

import com.emmanueljohnsnbruna.Blackbrowncommunity.data.model.Event;
import com.emmanueljohnsnbruna.Blackbrowncommunity.data.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    public List<Event> searchEventsByHashtag(String hashtag) {
        return eventRepository.findByHashtagsHashtag(hashtag);
    }
}