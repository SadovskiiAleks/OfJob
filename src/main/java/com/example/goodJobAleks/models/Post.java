package com.example.goodJobAleks.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

import static com.example.goodJobAleks.models.StatusOfPost.DRAFT;

@Data
@Entity
@Table(name ="post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "user_name")
    private String user_name;
    @Column(name = "title")
    private String title;
    @Column(name = "fullText")
    private String fullText;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "statusOfPost")
    private StatusOfPost statusOfPost;
    @Column(name = "date")
    private Date date;

    public Post(){

    }

    public Post(String title, String fullText, String user_name) {
        this.user_name = user_name;
        this.title = title;
        this.fullText = fullText;
        this.statusOfPost = DRAFT;
        this.date = new Date();
    }



}
