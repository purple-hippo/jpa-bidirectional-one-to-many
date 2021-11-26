package com.example.bidirectionalonetomanyh2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Slf4j
public class BidirectionalOneToManyH2Application {

    public static void main(String[] args) {
        SpringApplication.run(BidirectionalOneToManyH2Application.class, args);
    }

    @Bean
    public CommandLineRunner runner(PostRepository postRepository) {
        return args -> {
            Post post = new Post("fp");
            log.warn("post created" + post);
            PostComment c1 = new PostComment("c1WWWrev");
            PostComment c2 = new PostComment("c2WWWrev");

            post.getComments().add(c1);
            log.warn("comment created " + c1);
            post.getComments().add(c2);
            log.warn("comment created " + c2);

            postRepository.save(post);
//            postRepository.delete(post);
//            log.warn("" + post.getComments().size());

//            post.getComments().remove(c2);
//            log.warn("after del of comment c2: " + post.getComments().size());

        };
    }
}
