package com.example.bidirectionalonetomanyh2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Slf4j
public class BidirectionalOneToManyApplication {

    public static void main(String[] args) {
        SpringApplication.run(BidirectionalOneToManyApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner(PostRepository postRepository) {
        return args -> {
            Post post = new Post("fp");
            log.warn("post created" + post);
            Comment c1 = new Comment("comment1");
            Comment c2 = new Comment("comment2");

            post.addComment(c1);
            log.warn("comment created " + c1);
            post.addComment(c2);
            log.warn("comment created " + c2);

            postRepository.save(post);

        };
    }
}
