package com.kipcode.blogapp.controller;
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
@CrossOrigin
@RestController
@RequestMapping(path="/blogs")
public class BlogController {
    @Autowired
    private BlogService blogServiceImpl;
    @Autowired
    private WriterRepository writerRepository;

    @PostMapping("/create-blog")
    public Blog createBlog(@RequestBody BlogRequest request){
        return blogServiceImpl.saveBlog(request.getBlog());
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
    public ResponseEntity<Blog> getBlogById(@PathVariable int id){
        Blog blog = blogServiceImpl.getBlogById(id);
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Blog> updateBlog(@RequestBody Blog blog){
        //Blog blog = blogRequest.getBlog();
        System.out.println(blog.toString() + "###############");
        //System.out.println(blog.getId());
        Blog blogUpdate = blogServiceImpl.updateBlog(blog);
        return new ResponseEntity<>(blogUpdate, HttpStatus.OK);
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
