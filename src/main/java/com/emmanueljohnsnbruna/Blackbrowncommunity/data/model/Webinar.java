package com.emmanueljohnsnbruna.Blackbrowncommunity.data.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "webinars")
@Setter
@Getter
@NoArgsConstructor @AllArgsConstructor
public class Webinar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Description is required")
    private String description;

    @NotNull(message = "Date and time is required")
    @Future(message = "Date and time must be in the future")
    private LocalDateTime dateTime;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "webinar_hashtags",
            joinColumns = @JoinColumn(name = "webinar_id"),
            inverseJoinColumns = @JoinColumn(name = "hashtag_id"))
    private Set<Hashtag> hashtags = new HashSet<>();

}
