package com.emmanueljohnsnbruna.Blackbrowncommunity.data.repository;


import com.emmanueljohnsnbruna.Blackbrowncommunity.data.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
//    List<Post> findByHashtagsContains(String hashtag);
    List<Post> findByHashtagsContainsIgnoreCase(String hashtag);
    List<Post> findByHashtagsContainingIgnoreCase(String hashtag);

    List<Post>findByLabelsContainingIgnoreCase(String label);

    List<Post> findByHashtagsOrLabelsContainingIgnoreCase(String query);

    List<Post> findByCreatedAtAfter(LocalDateTime cutoffTime);
}
