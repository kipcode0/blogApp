package com.kipcode.jpa.dto;

import java.util.Date;

public class BlogResponse {
    private String title;
    private String content;
    private String genre;
    private Date date;

    public BlogResponse(){};
    public BlogResponse(String title, String content, String genre, Date date) {
        this.title = title;
        this.content = content;
        this.genre = genre;
        this.date = date;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "BlogResponse{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", genre='" + genre + '\'' +
                ", date=" + date +
                '}';
    }
}
