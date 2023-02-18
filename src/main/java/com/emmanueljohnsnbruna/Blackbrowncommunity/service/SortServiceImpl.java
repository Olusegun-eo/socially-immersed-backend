package com.emmanueljohnsnbruna.Blackbrowncommunity.service;



import com.emmanueljohnsnbruna.Blackbrowncommunity.data.model.Post;
import com.emmanueljohnsnbruna.Blackbrowncommunity.data.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SortServiceImpl implements SortService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public List<Post> sortPostsByHashtag(String hashtag) {
//        return postRepository.findByHashtag(hashtag);
        return postRepository.findByHashtagsContainsIgnoreCase(hashtag);
    }
}
