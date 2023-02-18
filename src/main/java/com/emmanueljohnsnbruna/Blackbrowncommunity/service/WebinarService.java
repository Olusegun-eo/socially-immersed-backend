package com.emmanueljohnsnbruna.Blackbrowncommunity.service;


import com.emmanueljohnsnbruna.Blackbrowncommunity.data.model.Webinar;
import com.emmanueljohnsnbruna.Blackbrowncommunity.data.repository.WebinarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WebinarService {
    @Autowired
    private WebinarRepository webinarRepository;

    public Webinar createWebinar(Webinar webinar) {
        return webinarRepository.save(webinar);
    }

    public Webinar updateWebinar(Long id, Webinar webinar) {
        if (webinar.getId() == null) {
            throw new IllegalArgumentException("Webinar id cannot be null.");
        }
        return webinarRepository.save(webinar);
    }

    public void deleteWebinar(Long webinarId) {
        webinarRepository.deleteById(webinarId);
    }

    public Optional<Webinar> getWebinarById(Long webinarId) {
        return webinarRepository.findById(webinarId);
    }

    public List<Webinar> getAllWebinars() {
        return webinarRepository.findAll();
    }

    public List<Webinar> getWebinarsByHashtag(String hashtag) {
        return webinarRepository.findByHashtagsHashtag(hashtag);
    }
}
