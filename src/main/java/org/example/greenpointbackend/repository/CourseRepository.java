package org.example.greenpointbackend.repository;

import org.example.greenpointbackend.model.Course;
import org.example.greenpointbackend.model.Enums.JobTitle;
import org.example.greenpointbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

    @Repository
    public interface CourseRepository extends JpaRepository<Course, Integer> {
        List<Course> findCoursesByJobTitle(JobTitle jobTitle);

        @Query("SELECT c FROM Course c JOIN c.users u WHERE u.id = :userId")
        List<Course> findCoursesByUserId(@Param("userId") int userId);

        @Query("SELECT u FROM User u JOIN u.courses c WHERE c.id = :courseId")
        List<User> findUsersByCourseId(@Param("courseId") int courseId);

    }

