package com.example.bidirectionalonetomanyh2.controllers;

import com.example.bidirectionalonetomanyh2.Post;
import com.example.bidirectionalonetomanyh2.Comment;
import com.example.bidirectionalonetomanyh2.PostRepository;
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
