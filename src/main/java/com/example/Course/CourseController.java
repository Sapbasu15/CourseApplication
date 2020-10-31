package com.example.Course;

import com.example.Topic.Model.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/topic/{topicId}")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("/courses")
    public List<Course> getCourse(@PathVariable String topicId){
        return courseService.getCoursesByTopicId(topicId);
    }

    @RequestMapping("/courses/{courseId}")
    public Course getCourseById(@PathVariable String topicId, @PathVariable String courseId){
        Course course = courseService.getCourseById(courseId);
        if(course == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Course Not Found");
        return course;
    }

    @PostMapping("/courses")
    public void addCourse(@PathVariable String topicId, @RequestBody List<Course> courses){
        courses.forEach(course -> {
            course.setTopic(new Topic(topicId,"",""));
            courseService.addCourse(course);
        });
    }

    @PutMapping("/courses/{courseId}")
    public void updateCourse(@PathVariable String topicId, @PathVariable String courseId,@RequestBody Course course){
        course.setTopic(new Topic(topicId,"ww","qq"));
        courseService.updateCourse(courseId, course);
    }

    @DeleteMapping("/courses/{courseId}")
    public void deleteCourse(@PathVariable String courseId){
        courseService.deleteCourse(courseId);
    }
}
