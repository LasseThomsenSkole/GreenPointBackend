package org.example.greenpointbackend.repository;

import org.example.greenpointbackend.model.Course;
import org.example.greenpointbackend.model.Enums.JobTitle;
import org.example.greenpointbackend.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

    @Repository
    public interface CourseRepository extends JpaRepository<Course, Long> {
        List<Course> findCoursesByJobTitle(JobTitle jobTitle);

        @Query("SELECT c FROM Course c WHERE " +
                "(LOWER(c.title) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
                "OR LOWER(c.description) LIKE LOWER(CONCAT('%', :keyword, '%'))) ")
        Page<Course> searchCourse(@Param("keyword") String keyword,
                              Pageable pageable);
    }