package com.emmanueljohnsnbruna.Blackbrowncommunity.web;


import com.emmanueljohnsnbruna.Blackbrowncommunity.data.model.Webinar;
import com.emmanueljohnsnbruna.Blackbrowncommunity.service.UserService;
import com.emmanueljohnsnbruna.Blackbrowncommunity.service.WebinarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/webinars")
public class WebinarsController {
    private final WebinarService webinarService;
    private final UserService userService;

    public WebinarsController(WebinarService webinarService, UserService userService) {
        this.webinarService = webinarService;
        this.userService = userService;
    }

    @GetMapping("/getWebinarById{id}")
    public ResponseEntity<Webinar> getWebinarById(@PathVariable Long id) {
        Optional<Webinar> webinar = webinarService.getWebinarById(id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getAllWebinars")
    public ResponseEntity<List<Webinar>> getAllWebinars() {
        List<Webinar> webinars = webinarService.getAllWebinars();
        return new ResponseEntity<>(webinars, HttpStatus.OK);
    }

    @PostMapping("/createWebinar")
    public ResponseEntity<Webinar> createWebinar(@RequestBody Webinar webinarDto) {
        Webinar createdWebinar = webinarService.createWebinar(webinarDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdWebinar);
    }


    @PutMapping("/update{id}")
    public ResponseEntity<Webinar> updateWebinar(@PathVariable Long id, @RequestBody Webinar webinar) {
        Webinar updatedWebinar = webinarService.updateWebinar(id, webinar);
        return ResponseEntity.ok(updatedWebinar);
    }

    @DeleteMapping("/delete{id}")
    public ResponseEntity<Void> deleteWebinar(@PathVariable Long id) {
        webinarService.deleteWebinar(id);
        return ResponseEntity.noContent().build();
    }
}












