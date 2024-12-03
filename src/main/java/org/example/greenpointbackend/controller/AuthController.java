package org.example.greenpointbackend.controller;

import org.example.greenpointbackend.model.Course;
import org.example.greenpointbackend.model.Enums.Role;
import org.example.greenpointbackend.model.Post;
import org.example.greenpointbackend.security.AuthenticationRequest;
import org.example.greenpointbackend.model.User;
import org.example.greenpointbackend.repository.UserRepository;
import org.example.greenpointbackend.security.UserPrincipal;
import org.example.greenpointbackend.security.JwtUtil;
import org.example.greenpointbackend.service.CourseService;
import org.example.greenpointbackend.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    PostService postService;

    @Autowired CourseService courseService;


    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        if (userRepository.findByUsername(user.getUsername()) != null) return ResponseEntity.badRequest()
                .body("User already exists");

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.ADMIN);
        userRepository.save(user);
        return ResponseEntity.ok("User created");
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(auth);
        final UserPrincipal userPrincipal = (UserPrincipal) auth.getPrincipal();
        System.out.println("role: " + userPrincipal.getAuthorities()); // Add logging
        return jwtUtil.generateToken(userPrincipal);
    }
    @GetMapping("/validate-role")
    public ResponseEntity<List<String>> validateRole(@AuthenticationPrincipal UserPrincipal userPrincipal) {
        List<String> roles = userPrincipal.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        return ResponseEntity.ok(roles);
    }

    @GetMapping("/role-newsfeed")
    public ResponseEntity<List<Map<String, Object>>> getRoleNews(@AuthenticationPrincipal UserPrincipal userPrincipal){
        List<String> roles = userPrincipal.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        List<Post> roleNews = new ArrayList<>();
        for(String role : roles){
            roleNews.addAll(postService.findNewsByRole(role)); //det her virker kun når findnewsbyrole i service er static??
        }

        List<Map<String, Object>> foundNews = roleNews.stream()
                .distinct()
                .map(news -> {
                    Map<String, Object> newsDetails = new HashMap<>();
                    newsDetails.put("title", news.getTitle());
                    newsDetails.put("date", news.getDate());
                    newsDetails.put("description", news.getDescription());
                    return newsDetails;
                })
                .collect(Collectors.toList());

        return ResponseEntity.ok(foundNews);
    }

    @GetMapping("/role-coursefeed")
    public ResponseEntity<List<Map<String, Object>>> getRoleCourses(@AuthenticationPrincipal UserPrincipal userPrincipal){
        List<String> roles = userPrincipal.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        List<Course> roleCourses = new ArrayList<>();
        for(String role : roles){
            roleCourses.addAll(courseService.findCourseByRole(role));
        }

        List<Map<String, Object>> foundCourses = roleCourses.stream()
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

    @GetMapping("/test")
    public String test(@AuthenticationPrincipal UserPrincipal userPrincipal) {
        return "Test: " + userPrincipal.getUsername();
    }
    @GetMapping("/admin")
    public String admin(@AuthenticationPrincipal UserPrincipal userPrincipal) {
        return "Hello, Admin!";
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }
}
