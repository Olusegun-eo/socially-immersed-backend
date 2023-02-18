package com.emmanueljohnsnbruna.Blackbrowncommunity.data.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "courses")
@Getter
@Setter
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title is required")
    private String name;

    @NotBlank(message = "Description is required")
    private String description;

    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private LocalDateTime createdAt;

    private long price;
    @ManyToOne
    private User author;


    @OneToMany(mappedBy = "hashtag")
    private Set<Hashtag> hashtags = new HashSet<>();

    @OneToMany(mappedBy = "course")
    private List<Resource> resources;
}
