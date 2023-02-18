package com.emmanueljohnsnbruna.Blackbrowncommunity.web;


import com.emmanueljohnsnbruna.Blackbrowncommunity.data.model.Post;
import com.emmanueljohnsnbruna.Blackbrowncommunity.data.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        // Get all posts and add them to the model
        List<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);

        return "admin/dashboard";
    }
}
