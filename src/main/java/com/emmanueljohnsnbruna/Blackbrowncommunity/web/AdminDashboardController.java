package com.emmanueljohnsnbruna.Blackbrowncommunity.web;


import com.emmanueljohnsnbruna.Blackbrowncommunity.data.model.Label;
import com.emmanueljohnsnbruna.Blackbrowncommunity.data.model.Post;
import com.emmanueljohnsnbruna.Blackbrowncommunity.data.repository.LabelRepository;
import com.emmanueljohnsnbruna.Blackbrowncommunity.data.repository.PostRepository;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Comparator;
import java.util.List;

@Controller
@RequestMapping("/admin")
@Secured("ROLE_ADMIN")
public class AdminDashboardController {

    private final LabelRepository labelRepository;
    private final PostRepository postRepository;

    public AdminDashboardController(LabelRepository labelRepository, PostRepository postRepository) {
        this.labelRepository = labelRepository;
        this.postRepository = postRepository;
    }

    @GetMapping("/dashboard")
    public String showDashboard(Model model) {
        List<Label> labels = labelRepository.findAll();
        List<Post> posts = postRepository.findAll();

        // Calculate statistics for the dashboard
        int numLabels = labels.size();
        int numPosts = posts.size();

        // Add the statistics to the model for display in the view
        model.addAttribute("numLabels", numLabels);
        model.addAttribute("numPosts", numPosts);

        return "admin/dashboard";
    }

    @GetMapping("/dashboard/labels")
    public String showLabelsDashboard(Model model) {
        List<Label> labels = labelRepository.findAll();

        // Sort labels by post count in descending order
        labels.sort(Comparator.comparingInt(label -> label.getPosts().size()).reversed());

        // Add the sorted labels to the model for display in the view
        model.addAttribute("labels", labels);

        return "admin/labels_dashboard";
    }
}
