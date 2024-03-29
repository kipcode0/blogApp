package com.kipcode.blogapp.service;

import com.kipcode.blogapp.exceptions.ResourceNotFoundException;
import com.kipcode.blogapp.model.Blog;
import com.kipcode.blogapp.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogServiceImpl implements BlogService{
     @Autowired
    private BlogRepository blogRepository;

    @Override
    public Blog saveBlog(Blog blog) {
        return blogRepository.save(blog);
    }

    @Override
    public Blog getBlogById(Long id) {
        Blog blog = blogRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Not found Blog with id = " + id));
        return blog;
    }

    @Override
    public Blog updateBlog(Blog blog) {
        Blog existingBlog = blogRepository.findById(blog.getId()).orElseThrow(()->new ResourceNotFoundException("Not found Blog with id = " + blog.getId()));
        existingBlog.setContent(blog.getContent());
        existingBlog.setGenre(blog.getGenre());
        existingBlog.setTitle(blog.getTitle());
        existingBlog.setDate(blog.getDate());
        return blogRepository.save(existingBlog);
    }

    @Override
    public void deleteBlog(String id) {

    }


}
