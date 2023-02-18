package com.emmanueljohnsnbruna.Blackbrowncommunity.data.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToOne
    private User author;

    @Column(columnDefinition = "TEXT")
    private String content;

    @ManyToMany
    @JoinTable(name = "post_label",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "label_id"))
    private List<Label> labels = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "post_label",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "label_id"))
    private List<Hashtag> hashtags = new ArrayList<>();

}
