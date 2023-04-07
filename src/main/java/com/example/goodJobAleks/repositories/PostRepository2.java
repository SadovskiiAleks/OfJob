package com.example.goodJobAleks.repositories;

import com.example.goodJobAleks.models.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface PostRepository2 extends JpaRepository<Post,Long> {


    @Query("SELECT * FROM post WHERE user_name LIKE '%keyword%'")
    List<Post> findByNameStartingWith(String name);
}