package com.kipcode.blogapp.controller;

import com.kipcode.blogapp.exceptions.BlogErrorResponse;
import com.kipcode.blogapp.exceptions.ResourceNotFoundException;
import com.kipcode.blogapp.model.Blog;
import com.kipcode.blogapp.model.Writer;
import com.kipcode.blogapp.repository.BlogRepository;
import com.kipcode.blogapp.repository.WriterRepository;
import com.kipcode.blogapp.service.BlogService;
import com.kipcode.jpa.dto.WriterRequest;
import com.kipcode.jpa.dto.blogRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping(path="/blog")
public class BlogController {
    @Autowired
    private BlogRepository blogRepository;
    @Autowired
    private WriterRepository writerRepository;

    @PostMapping("/create-blog")
    public Writer createBlog(@RequestBody WriterRequest request){
        return writerRepository.save(request.getWriter());
    }

    @GetMapping("/find-writers")
    public List<Writer> findWriters(){
        return writerRepository.findAll();
    }

    @GetMapping("/find-blogs")
    public List<Blog> findAllBlogs(){
        return blogRepository.findAll();
    }

    /*
    @GetMapping("/find-blogs/{id}")
    public ResponseEntity<Blog> getBlogById(@PathVariable int id){
        Blog blog = blogRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Not found Blog with id = " + id));
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }
     */

    @GetMapping("/find-blogs/{title}")
    public ResponseEntity<Blog> getBlogByTitle(@PathVariable String title){
        Blog blog = blogRepository.findByTitleIgnoreCase(title).orElseThrow(()->new ResourceNotFoundException("Did not find Blog with title " + title));
        return new ResponseEntity<>(blog, HttpStatus.NOT_FOUND);
    }

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
