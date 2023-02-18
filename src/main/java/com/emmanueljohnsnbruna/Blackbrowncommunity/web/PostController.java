package com.emmanueljohnsnbruna.Blackbrowncommunity.web;

import com.emmanueljohnsnbruna.Blackbrowncommunity.data.model.Post;
import com.emmanueljohnsnbruna.Blackbrowncommunity.data.model.User;
import com.emmanueljohnsnbruna.Blackbrowncommunity.data.repository.UserRepository;
import com.emmanueljohnsnbruna.Blackbrowncommunity.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/posts")
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        Post newPost = postService.createPost(post);
        return new ResponseEntity<>(newPost, HttpStatus.CREATED);
    }

    public String createPost(@ModelAttribute Post post, Principal principal) {
        User user = userRepository.findByUsername(principal.getName());
        post.setUser(user);
        postRepository.save(post);
        return "redirect:/posts/" + post.getId();
    }

    @GetMapping("/posts")
    public ResponseEntity<List<Post>> getAllPosts() {
        List<Post> posts = postService.getAllPosts();
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Long id) {
        Post post = postService.getPostById(id);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @PutMapping("/posts/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable Long id, @RequestBody Post post) {
        Post updatedPost = postService.updatePost(id, post);
        return new ResponseEntity<>(updatedPost, HttpStatus.OK);
    }

    @DeleteMapping("/posts/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/posts/search")
    public ResponseEntity<List<Post>> searchPostsByHashtag(@RequestParam("hashtag") String hashtag) {
        List<Post> posts = postService.searchPostsByHashtag(hashtag);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }
}
