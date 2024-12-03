package org.example.greenpointbackend.service;

import org.example.greenpointbackend.model.News;
import org.example.greenpointbackend.repository.NewsRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService {
    private NewsRepository newsRepository;

    public NewsService() {
        this.newsRepository = newsRepository;
    }

    public Page<News> searchNews(String keyword, int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("date").descending());
        return newsRepository.searchNews(keyword, pageable);
    }

    public List<News> findNewsByRole(String role){
        return newsRepository.findNewsByRole(role);
    }
}
