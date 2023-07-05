package com.kipcode.blogapp.service;

import com.kipcode.blogapp.model.Blog;

public interface BlogService {
     Blog saveBlog(Blog blog);
     Blog getBlogById(int id);
    // Blog getBlogByTitle(String title);
    // Blog getBlogByAuthor(String author);
    Blog updateBlog(Blog blog);
    //void deleteBlog(String id);
}
