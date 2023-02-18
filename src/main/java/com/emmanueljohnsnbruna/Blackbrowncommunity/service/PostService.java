package com.emmanueljohnsnbruna.Blackbrowncommunity.service;


import com.emmanueljohnsnbruna.Blackbrowncommunity.data.model.Post;
import com.emmanueljohnsnbruna.Blackbrowncommunity.data.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class PostService {
    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post createPost(Post post) {
        postRepository.save(post);
        return post;
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public List<Post> searchPosts(String query) {
        return postRepository.findByHashtagsOrLabelsContainingIgnoreCase(query);
    }

    public List<Post> searchByHashtag(String hashtag) {
        return postRepository.findByHashtagsContainsIgnoreCase(hashtag);
    }
}
