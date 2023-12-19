package com.kipcode.blogapp.repository;

import com.kipcode.blogapp.model.Blog;
import com.kipcode.blogapp.model.Writer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Repository
public interface WriterRepository extends JpaRepository<Writer, Long> {
   //Writer findByEmail(String email);
   Optional<Writer> findByEmail(String email);

}
