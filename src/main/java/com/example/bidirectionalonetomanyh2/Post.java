package com.example.bidirectionalonetomanyh2;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;

    public Post(String title) {
        this.title = title;
    }

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id")
    List<Comment> comments = new ArrayList<>();

    public void addComment(Comment comment){
        comments.add(comment);
    }

    public void removeComment(Comment comment){
        comments.remove(comment);
    }
}
