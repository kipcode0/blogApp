package com.kipcode.jpa.dto;

import com.kipcode.blogapp.model.Blog;

public class BlogRequest {
   private String title;
   private String content;
   private String genre;
   private String writer;

   public BlogRequest(){

   }
    public BlogRequest(String title, String content, String genre, String writer) {
        this.title = title;
        this.content = content;
        this.genre = genre;
        this.writer = writer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    /*
    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

     */
}
/*
* private String title;
    private String content;
    private String genre;

    private String writer;
    private Date date;
*
*  */