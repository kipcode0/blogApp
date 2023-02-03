package com.kipcode.blogapp.controller;

import com.kipcode.blogapp.model.Blog;
import com.kipcode.blogapp.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/blog")
public class BlogController {
    @Autowired
    private BlogService blogService;

    @PostMapping("/add")
    public String add(Blog blog){
        blogService.saveBlog(blog);
        return "New Blog Added";
    }
}
