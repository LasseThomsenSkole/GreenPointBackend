package org.example.greenpointbackend.controller;

import org.example.greenpointbackend.model.Course;
import org.example.greenpointbackend.model.Enums.JobTitle;
import org.example.greenpointbackend.security.UserPrincipal;
import org.example.greenpointbackend.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/kalender")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/coursefeed")
    public ResponseEntity<List<Map<String, Object>>> getRoleCourses(@AuthenticationPrincipal UserPrincipal userPrincipal){
        JobTitle jobTitle = userPrincipal.getJobTitle();

        List<Course> jobTitleCourses = courseService.findCourseByRole(JobTitle.valueOf(jobTitle.name()));


        List<Map<String, Object>> foundCourses = jobTitleCourses.stream()
                .distinct()
                .map(course -> {
                    Map<String, Object> CourseDetails = new HashMap<>();
                    CourseDetails.put("title", course.getTitle());
                    CourseDetails.put("description", course.getDescription());
                    CourseDetails.put("date", course.getDate());
                    CourseDetails.put("startTime", course.getStartTime());
                    CourseDetails.put("endTime", course.getEndTime());
                    CourseDetails.put("location", course.getLocation());
                    return CourseDetails;
                })
                .collect(Collectors.toList());

        return ResponseEntity.ok(foundCourses);
    }

}
