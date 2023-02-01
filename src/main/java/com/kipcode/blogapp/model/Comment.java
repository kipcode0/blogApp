package com.kipcode.blogapp.model;

import java.util.Date;

public class Comment {
    private String Id;
    private String content;
    private Writer writer;
    private Blog blog;
    private Date date;

    public Comment() {
    }

    public Comment(String id, String content, Writer writer, Blog blog, Date date) {
        Id = id;
        this.content = content;
        this.writer = writer;
        this.blog = blog;
        this.date = date;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Writer getWriter() {
        return writer;
    }

    public void setWriter(Writer writer) {
        this.writer = writer;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "Id='" + Id + '\'' +
                ", content='" + content + '\'' +
                ", writer=" + writer +
                ", blog=" + blog +
                ", date=" + date +
                '}';
    }
}
