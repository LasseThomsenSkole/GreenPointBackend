package org.example.greenpointbackend.repository;

import org.example.greenpointbackend.model.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface NewsRepository extends JpaRepository<News, Integer> {
    @Query("SELECT n FROM News n WHERE " +
            "(LOWER(n.title) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(n.description) LIKE LOWER(CONCAT('%', :keyword, '%'))) " +
            "AND (:startDate IS NULL OR n.date >= :startDate) " +
            "AND (:endDate IS NULL OR n.date <= :endDate)")
    Page<News> searchNews(@Param("keyword") String keyword,
                          Pageable pageable);

    List<News> findNewsByRole(String role);
}

