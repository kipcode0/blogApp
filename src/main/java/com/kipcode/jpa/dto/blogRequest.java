package com.kipcode.jpa.dto;

import com.kipcode.blogapp.model.Blog;

public class blogRequest {
    private Blog blog;

    public blogRequest() {
    }

    public blogRequest(Blog blog) {
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
