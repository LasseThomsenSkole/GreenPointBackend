package org.example.greenpointbackend.service;

import org.example.greenpointbackend.model.Course;
import org.example.greenpointbackend.model.Enums.JobTitle;
import org.example.greenpointbackend.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    private CourseRepository courseRepository;


    public List<Course> findCourseByRole(JobTitle jobTitle){
        return courseRepository.findCoursesByJobTitle(jobTitle);
    }

}