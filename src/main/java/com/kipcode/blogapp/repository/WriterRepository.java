package com.kipcode.blogapp.repository;

import com.kipcode.blogapp.model.Blog;
import com.kipcode.blogapp.model.Writer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;


public interface WriterRepository extends JpaRepository<Writer, Integer> {
  //return blogs from a writer
   /*
   * @Query("SELECT m FROM Movie m WHERE m.title LIKE %:title%")
     List<Movie> searchByTitleLike(@Param("title") String title);
   * */

}
