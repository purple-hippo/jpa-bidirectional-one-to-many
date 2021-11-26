package com.example.bidirectionalonetomanyh2;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String review;

    public Comment(String review) {
        this.review = review;
    }
}
