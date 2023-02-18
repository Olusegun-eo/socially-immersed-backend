package com.emmanueljohnsnbruna.Blackbrowncommunity.service;


import com.emmanueljohnsnbruna.Blackbrowncommunity.data.model.Course;
import com.emmanueljohnsnbruna.Blackbrowncommunity.data.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course getCourseById(Long courseId) {
        return courseRepository.findById(courseId)
                .orElseThrow(() -> new IllegalArgumentException());
    }

    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    public Course updateCourse(Long courseId, Course courseDetails) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new IllegalArgumentException("Course id not found"));

        course.setName(courseDetails.getName());
        course.setDescription(courseDetails.getDescription());
        course.setStartDate(courseDetails.getStartDate());
        course.setEndDate(courseDetails.getEndDate());
        course.setPrice(courseDetails.getPrice());

        return courseRepository.save(course);
    }

    public void deleteCourse(Long courseId) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new IllegalArgumentException());

        courseRepository.delete(course);
    }

    public List<Course> getCoursesByHashtag(String hashtag) {
        return courseRepository.findByHashtagsLabel(hashtag);
    }

}
