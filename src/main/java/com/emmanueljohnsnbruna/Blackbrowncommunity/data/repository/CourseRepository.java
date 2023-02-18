package com.emmanueljohnsnbruna.Blackbrowncommunity.data.repository;

import com.emmanueljohnsnbruna.Blackbrowncommunity.data.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByHashtagsContainsIgnoreCase(String hashtag);

    List<Course> findByHashtagsLabel(String hashtag);
}

