package com.example.bidirectionalonetomany.controllers;

import com.example.bidirectionalonetomany.models.Post;
import com.example.bidirectionalonetomany.models.Comment;
import com.example.bidirectionalonetomany.repositories.PostRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController {
    private final PostRepository postRepository;

    public CommentController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @PostMapping("/{postId}/comment")
    public Comment addCommentByPostId(@PathVariable Long postId, @RequestBody Comment comment) {
        Post post = postRepository.findById(postId).get();
        post.addComment(comment);
        postRepository.save(post);
        return comment;
    }
}
