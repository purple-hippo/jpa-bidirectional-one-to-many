package com.example.bidirectionalonetomany.repositories;

import com.example.bidirectionalonetomany.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
