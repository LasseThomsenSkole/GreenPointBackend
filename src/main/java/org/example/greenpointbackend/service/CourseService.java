package org.example.greenpointbackend.service;

import org.example.greenpointbackend.model.Course;
import org.example.greenpointbackend.model.News;
import org.example.greenpointbackend.repository.CourseRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    private CourseRepository courseRepository;


    public List<Course> findCourseByRole(String role){
        return courseRepository.findCoursesByRole(role);
    }

}