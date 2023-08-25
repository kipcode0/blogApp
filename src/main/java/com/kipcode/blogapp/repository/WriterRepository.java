package com.kipcode.blogapp.repository;

import com.kipcode.blogapp.model.Blog;
import com.kipcode.blogapp.model.Writer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public interface WriterRepository extends JpaRepository<Writer, Long> {
  //return blogs from a writer
   /*
   * @Query("SELECT m FROM Movie m WHERE m.title LIKE %:title%")
     List<Movie> searchByTitleLike(@Param("title") String title);
   * */
  Writer findByEmail(String email);

}
