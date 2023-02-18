package com.emmanueljohnsnbruna.Blackbrowncommunity.web;

import com.emmanueljohnsnbruna.Blackbrowncommunity.data.model.Post;
import com.emmanueljohnsnbruna.Blackbrowncommunity.service.HashtagService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hashtags")
public class HashtagController {

    private HashtagService hashtagService;

    public HashtagController(HashtagService hashtagService) {
        this.hashtagService = hashtagService;
    }

    @GetMapping("/trending")
    public List<String> getTrendingHashtags() {
        return hashtagService.getTrendingHashtags();
    }

    @GetMapping("/{hashtag}/posts")
    public List<Post> getPostsForHashtag(@PathVariable("hashtag") String hashtag) {
        return hashtagService.getPostsForHashtag(hashtag);
    }

    @GetMapping("/{label}/posts")
    public List<Post> getPostsForLabel(@PathVariable("label") String label) {
        return hashtagService.getPostsForLabel(label);
    }
}
