package org.example.greenpointbackend.repository;

import org.example.greenpointbackend.model.Course;
import org.example.greenpointbackend.model.Enums.JobTitle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

    @Repository
    public interface CourseRepository extends JpaRepository<Course, Long> {
        List<Course> findCoursesByJobTitle(JobTitle jobTitle);
    }

