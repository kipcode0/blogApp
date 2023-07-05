package com.kipcode.jpa.dto;

import com.kipcode.blogapp.model.Blog;

public class BlogRequest {
    private Blog blog;

    public BlogRequest() {
    }

    public BlogRequest(Blog blog) {
        this.blog = blog;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    @Override
    public String toString() {
        return "blogRequest{" +
                "blog=" + blog +
                '}';
    }
}
