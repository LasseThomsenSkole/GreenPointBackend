package org.example.greenpointbackend.service;

import org.example.greenpointbackend.model.Course;
import org.example.greenpointbackend.model.Enums.JobTitle;
import org.example.greenpointbackend.model.User;
import org.example.greenpointbackend.repository.CourseRepository;
import org.example.greenpointbackend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    private CourseRepository courseRepository;
    private UserRepository userRepository;


    public List<Course> findCourseByRole(JobTitle jobTitle){
        return courseRepository.findCoursesByJobTitle(jobTitle);
    }

    public void registerUserToCourse(int userId, int courseId){
        User user = userRepository.findById(userId).orElseThrow(() ->new RuntimeException());
        Course course = courseRepository.findById(courseId).orElseThrow(() ->new RuntimeException());
        course.getUsers().add(user);
        courseRepository.save(course);
    }

    public void unregisterUserFromCourse(int userId, int courseId){
        Course course = courseRepository.findById(courseId).orElseThrow(()->new RuntimeException());
        course.getUsers().remove(userId);
        courseRepository.save(course);
    }

    public List<Course> findCoursesByUserId(int userId){
        return courseRepository.findCoursesByUserId(userId);
    }

    public List<User> findUsersByCourseId(int courseId){
        return courseRepository.findUsersByCourseId(courseId);
    }
}