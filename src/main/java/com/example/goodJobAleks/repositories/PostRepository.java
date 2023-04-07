package com.example.goodJobAleks.repositories;

import com.example.goodJobAleks.models.Post;

import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//public interface PostRepository extends CrudRepository<Post,Long>{
//}
@Repository
public interface PostRepository extends JpaRepository<Post,Long> {

    Page<Post> findAll(Pageable pageable);

}