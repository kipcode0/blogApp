package com.kipcode.blogapp.repository;
import com.kipcode.blogapp.model.Blog;
import com.kipcode.blogapp.model.Writer;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface BlogRepository extends JpaRepository<Blog, Integer> {
    Optional<Blog> findByTitleIgnoreCase(String title);
}
