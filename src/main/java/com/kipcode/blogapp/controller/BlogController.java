package com.kipcode.blogapp.controller;
import com.kipcode.blogapp.repository.BlogRepository;
import org.springframework.web.bind.annotation.RequestBody;
import com.kipcode.blogapp.exceptions.BlogErrorResponse;
import com.kipcode.blogapp.exceptions.ResourceNotFoundException;
import com.kipcode.blogapp.model.Blog;
import com.kipcode.blogapp.model.Writer;
import com.kipcode.blogapp.repository.WriterRepository;
import com.kipcode.blogapp.service.BlogService;
import com.kipcode.blogapp.service.BlogServiceImpl;
import com.kipcode.jpa.dto.BlogRequest;
import com.kipcode.jpa.dto.BlogResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping(path="/blogs")
public class BlogController {
    @Autowired
    private BlogService blogServiceImpl;
    @Autowired
    private WriterRepository writerRepository;

    @Autowired
    BlogRepository blogRepository;
    @PostMapping("/create-blog")
    public ResponseEntity<Blog> createBlog(@RequestBody Blog blog){
         //blogServiceImpl.saveBlog(blog);
        try{
            Blog newBlog = blogRepository.save(new Blog(blog.getTitle(),blog.getGenre(),blog.getContent(),blog.getDate()));
            return new ResponseEntity<>(newBlog, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/find-writers")
    public List<Writer> findWriters(){
        return writerRepository.findAll();
    }

    /*
    @GetMapping("/find-blogs")
    public List<Blog> findAllBlogs(){
        return blogRepository.findAll();
    }
     */

    @GetMapping("/find-blog/{id}")
    public ResponseEntity<Blog> getBlogById(@PathVariable Long id){
        Blog blog = blogServiceImpl.getBlogById(id);
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Blog> updateBlog(@PathVariable("id") Long id, @RequestBody Blog blog){
        Optional<Blog> blogData = blogRepository.findById(id);
         if(blogData.isPresent()){
             Blog updateBlog = blogData.get();
             updateBlog.setTitle(blog.getTitle());
             updateBlog.setContent(blog.getContent());
             updateBlog.setGenre(blog.getGenre());
             return new ResponseEntity<>(blogRepository.save(updateBlog), HttpStatus.OK);
         }else{
             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
         }

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Blog> deleteBlog(@PathVariable("id") Long id){
        try{
            blogRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/all")
    public ResponseEntity<HttpStatus> deleteAllTutorials() {
        try {
            blogRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


/*
    @GetMapping("/find-blogs/{title}")
    public ResponseEntity<Blog> getBlogByTitle(@PathVariable String title){
        Blog blog = blogRepository.findByTitleIgnoreCase(title).orElseThrow(()->new ResourceNotFoundException("Did not find Blog with title " + title));
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }
*/


    /*
    @GetMapping("/find-blogs/writers/{writer}")
    public ResponseEntity<Blog> getBlogByTitle(@PathVariable String writer){
        Blog blog = blogRepository.searchByWriter(writer).orElseThrow(()->new ResourceNotFoundException("Did not find Blog by " + writer));
        return new ResponseEntity<>(blog, HttpStatus.NOT_FOUND);
    }
     */
    @ExceptionHandler
    public ResponseEntity<BlogErrorResponse> handleException(ResourceNotFoundException exc){
        BlogErrorResponse error = new BlogErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

}
