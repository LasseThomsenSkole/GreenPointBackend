package org.example.greenpointbackend.service;

import lombok.NoArgsConstructor;
import org.example.greenpointbackend.model.Enums.JobTitle;
import org.example.greenpointbackend.model.Post;
import org.example.greenpointbackend.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public Page<Post> searchNews(String keyword, int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("date").descending());
        return postRepository.searchNews(keyword, pageable);
    }

    public List<Post> findNewsByJobTitle(JobTitle jobTitle){
        return postRepository.findNewsByJobTitle(jobTitle);
    }
}
