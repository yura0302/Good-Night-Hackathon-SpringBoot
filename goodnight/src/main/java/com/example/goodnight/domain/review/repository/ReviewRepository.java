package com.example.goodnight.domain.review.repository;

import com.example.goodnight.domain.review.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review,Long> {
    @Query(value = "select r from Review r where r.title like %:title% or r.content like %:content%")
    List<Review> findAllSearch(String title, String content, Pageable pageable);

}

