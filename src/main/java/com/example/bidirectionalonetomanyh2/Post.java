package com.example.bidirectionalonetomanyh2;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;

    public Post(String title) {
        this.title = title;
    }

    @OneToMany(
            cascade = CascadeType.ALL,
            mappedBy = "post",
            fetch = FetchType.EAGER,
            orphanRemoval = true
    )
    List<PostComment> comments = new ArrayList<>();
}
