package com.example.bidirectionalonetomany;

import com.example.bidirectionalonetomany.models.Comment;
import com.example.bidirectionalonetomany.models.Post;
import com.example.bidirectionalonetomany.repositories.PostRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class BidirectionalOneToManyApplication implements CommandLineRunner {

    public BidirectionalOneToManyApplication(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(BidirectionalOneToManyApplication.class, args);
    }

//    @Bean
//    public CommandLineRunner runner(PostRepository postRepository) {
//        return args -> {
//
//
//        };
//    }

    final PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        Post post = new Post("First post!");
        log.warn("post created" + post);

        Comment c1 = new Comment("comment1");
        log.warn("comment created " + c1);
        Comment c2 = new Comment("comment2");
        log.warn("comment created " + c2);

        post.addComment(c1);
        post.addComment(c2);
        postRepository.save(post);
    }
}
