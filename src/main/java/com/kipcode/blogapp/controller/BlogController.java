package com.kipcode.blogapp.controller;

import com.kipcode.blogapp.model.Blog;
import com.kipcode.blogapp.model.Writer;
import com.kipcode.blogapp.repository.BlogRepository;
import com.kipcode.blogapp.repository.WriterRepository;
import com.kipcode.blogapp.service.BlogService;
import com.kipcode.jpa.dto.WriterRequest;
import com.kipcode.jpa.dto.blogRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/blog")
public class BlogController {
    @Autowired
    private BlogRepository blogRepository;
    @Autowired
    private WriterRepository writerRepository;

    @PostMapping("/post-blog")
    public Writer getWriter(@RequestBody WriterRequest request){
       return writerRepository.save(request.getWriter());
    }

    @GetMapping("/find-all-blogs")
    public List<Blog> findAllBlogs(){
        return blogRepository.findAll();
    }
}
