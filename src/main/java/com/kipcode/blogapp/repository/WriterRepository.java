package com.kipcode.blogapp.repository;

import com.kipcode.blogapp.model.Writer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


public interface WriterRepository extends JpaRepository<Writer, Integer> {
}
