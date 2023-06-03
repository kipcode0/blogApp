package com.kipcode.blogapp.repository;
import com.kipcode.blogapp.model.Blog;
import com.kipcode.blogapp.model.Writer;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface BlogRepository extends JpaRepository<Blog, Integer> {
    Optional<Blog> findByTitleIgnoreCase(String title);
    /*
   * @Query("SELECT m FROM Movie m WHERE m.title LIKE %:title%")
     List<Movie> searchByTitleLike(@Param("title") String title);
   * */
    /*
    @Query("Select b from Blog blog.title, blog.genre, blog.content, blog.date From Blog INNER JOIN Writer ON  writer_detail_id = writer.id")
    Optional<Blog> searchByWriter(String writer);
     */
}
