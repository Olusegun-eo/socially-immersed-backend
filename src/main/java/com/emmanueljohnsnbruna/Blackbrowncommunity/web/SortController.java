package com.emmanueljohnsnbruna.Blackbrowncommunity.web;


import com.emmanueljohnsnbruna.Blackbrowncommunity.data.model.Post;
import com.emmanueljohnsnbruna.Blackbrowncommunity.service.SortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/sort")
public class SortController {

    @Autowired
    private SortService sortService;

    @GetMapping("/posts/{hashtag}")
    public List<Post> sortPostsByHashtag(@PathVariable String hashtag) {
        return sortService.sortPostsByHashtag(hashtag);
    }
}

