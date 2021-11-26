package com.example.bidirectionalonetomany.controllers;

import com.example.bidirectionalonetomany.models.Post;
import com.example.bidirectionalonetomany.repositories.PostRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {
    private final PostRepository postRepository;

    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPost(@PathVariable Long id) {
        var post = postRepository.findById(id).get();
        return ResponseEntity.ok(post);
    }

    @PostMapping
    public Post addPost(@RequestBody Post post) {
        postRepository.save(post);
        return post;
    }

    @DeleteMapping("/{postId}")
    public void deletePost(@PathVariable Long postId){
        postRepository.deleteById(postId);
    }

}
