package com.emmanueljohnsnbruna.Blackbrowncommunity.service;


import com.emmanueljohnsnbruna.Blackbrowncommunity.data.model.Post;
import org.springframework.stereotype.Service;

import java.util.List;

public interface SortService {
    List<Post> sortPostsByHashtag(String hashtag);
}
