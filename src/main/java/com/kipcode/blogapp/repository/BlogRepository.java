package com.kipcode.blogapp.repository;
import com.kipcode.blogapp.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Service;


public interface BlogRepository extends JpaRepository<Blog, Integer> {
}
