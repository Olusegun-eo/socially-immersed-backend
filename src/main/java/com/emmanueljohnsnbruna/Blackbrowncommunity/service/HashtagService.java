package com.emmanueljohnsnbruna.Blackbrowncommunity.service;


import com.emmanueljohnsnbruna.Blackbrowncommunity.data.model.Hashtag;
import com.emmanueljohnsnbruna.Blackbrowncommunity.data.model.Post;
import com.emmanueljohnsnbruna.Blackbrowncommunity.data.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HashtagService {

    private PostRepository postRepository;

    public HashtagService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<String> getTrendingHashtags() {
        // get all posts from the last 7 days
        LocalDateTime cutoffTime = LocalDateTime.now().minusDays(7);
        List<Post> posts = postRepository.findByCreatedAtAfter(cutoffTime);

        // count the occurrences of each hashtag in the posts
        Map<Hashtag, Integer> hashtagCounts = new HashMap<>();
        for (Post post : posts) {
            for (Hashtag hashtag : post.getHashtags()) {
                int count = hashtagCounts.getOrDefault(hashtag, 0);
                hashtagCounts.put(hashtag, count + 1);
            }
        }

        // sort the hashtags by occurrence count
        List<String> trendingHashtags = new ArrayList(hashtagCounts.keySet());
        trendingHashtags.sort((h1, h2) -> hashtagCounts.get(h2).compareTo(hashtagCounts.get(h1)));

        return trendingHashtags;
    }

    public List<Post> getPostsForHashtag(String hashtag) {
        return postRepository.findByHashtagsContainingIgnoreCase(hashtag);
    }

    public List<Post> getPostsForLabel(String label) {
        return postRepository.findByLabelsContainingIgnoreCase(label);
    }

}
