package org.example.greenpointbackend.controller;

import org.example.greenpointbackend.model.Post;
import org.example.greenpointbackend.security.UserPrincipal;
import org.example.greenpointbackend.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/news")
public class PostController {
    @Autowired
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }
    @GetMapping("/search")
    public ResponseEntity<Page<Post>> searchNews(
            @RequestParam(required = false) String keyword,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Page<Post> results = postService.searchNews(keyword, page, size);
        return ResponseEntity.ok(results);
    }

    @GetMapping("/role-newsfeed")
    public ResponseEntity<List<Map<String, Object>>> getRoleNews(@AuthenticationPrincipal UserPrincipal userPrincipal){
        List<String> roles = userPrincipal.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        List<Post> roleNews = new ArrayList<>();
        for(String role : roles){
            roleNews.addAll(postService.findPostsByRole(role)); //det her virker kun når findnewsbyrole i service er static??
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
}
