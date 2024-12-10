package org.example.greenpointbackend.service;

import org.example.greenpointbackend.model.Course;
import org.example.greenpointbackend.model.Enums.JobTitle;
import org.example.greenpointbackend.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;


    public List<Course> findCourseByRole(JobTitle jobTitle){
        return courseRepository.findCoursesByJobTitle(jobTitle);
    }
    public Page<Course> searchCourse(String keyword, int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("date").descending());

        if (keyword == null || keyword.trim().isEmpty()) { // if keyword is null or empty return all courses
            return courseRepository.findAll(pageable);
        }

        return courseRepository.searchCourse(keyword, pageable);
    }

}