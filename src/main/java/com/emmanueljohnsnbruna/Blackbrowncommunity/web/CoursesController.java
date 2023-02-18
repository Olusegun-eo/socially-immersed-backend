package com.emmanueljohnsnbruna.Blackbrowncommunity.web;

import com.emmanueljohnsnbruna.Blackbrowncommunity.data.model.Course;
import com.emmanueljohnsnbruna.Blackbrowncommunity.data.model.User;
import com.emmanueljohnsnbruna.Blackbrowncommunity.service.CourseService;
import com.emmanueljohnsnbruna.Blackbrowncommunity.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CoursesController {
    private final CourseService courseService;
    private final UserService userService;

    public CoursesController(CourseService courseService, UserService userService) {
        this.courseService = courseService;
        this.userService = userService;
    }

    @GetMapping("/getCourseById{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long id) {
        Course course = courseService.getCourseById(id);
        if (course != null) {
            return new ResponseEntity<>(course, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAllCourses")
    public ResponseEntity<List<Course>> getAllCourses() {
        List<Course> courses = courseService.getAllCourses();
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @PostMapping("/createCourse")
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {
        User user = userService.getCurrentUser(course.getName());
            course.setAuthor(user);
        course.setCreatedAt(LocalDateTime.now());
        Course newCourse = courseService.createCourse(course);
        return new ResponseEntity<>(newCourse, HttpStatus.CREATED);
    }

    @PutMapping("/updateCourse{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable Long id, @RequestBody Course course) {
        Course existingCourse = courseService.getCourseById(id);
        if (existingCourse == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        existingCourse.setName(course.getName());
        existingCourse.setDescription(course.getDescription());
        Course updatedCourse = courseService.updateCourse( id, existingCourse);
        return new ResponseEntity<>(updatedCourse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

