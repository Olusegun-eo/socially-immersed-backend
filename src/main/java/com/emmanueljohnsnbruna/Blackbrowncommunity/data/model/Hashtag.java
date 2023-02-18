package com.emmanueljohnsnbruna.Blackbrowncommunity.data.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "hashtags")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Hashtag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    private String title;

    private String description;

    @ManyToMany(mappedBy = "hashtags")
    private Set<Post> posts = new HashSet<>();
    @ManyToOne
    private User author;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "webinar_hashtags",
            joinColumns = @JoinColumn(name = "webinar_id"),
            inverseJoinColumns = @JoinColumn(name = "hashtag_id"))
    private Set<Webinar> hashtags = new HashSet<>();

}
