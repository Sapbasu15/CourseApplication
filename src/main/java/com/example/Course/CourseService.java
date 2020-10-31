package com.example.Course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getCoursesByTopicId(String topicId){
        return new ArrayList<>(courseRepository.findByTopicId(topicId));
    }

    public Course getCourseById(String courseId){
        Course course = null;
        try{
            course = courseRepository.findById(courseId).orElse(null);
        }catch (Exception ex){
            System.out.println(ex);
        }
        return course;
    }

    public void addCourse(Course course){
        try{
            courseRepository.save(course);
        }
        catch (Exception ex){
            System.out.println(ex);
        }
    }

    public void updateCourse(String courseId, Course course){
        course.setId(courseId);
        courseRepository.save(course);
    }

    public void deleteCourse(String courseId){
        courseRepository.deleteById(courseId);
    }

}
