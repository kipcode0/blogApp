package com.kipcode.blogapp.repository;

import com.kipcode.blogapp.model.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Integer> {
}
