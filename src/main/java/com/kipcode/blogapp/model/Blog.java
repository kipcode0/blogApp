package com.kipcode.blogapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private String Id;
    private String title;
    private String genre;
    private String content;
    private Date date;
    private Writer writer;
    private Comment comment;

    public Blog(){
        //default constructor
    }
    public Blog(String id, String title, String genre, String content, Date date, Writer writer, Comment comment) {
        Id = id;
        this.title = title;
        this.genre = genre;
        this.content = content;
        this.date = date;
        this.writer = writer;
        this.comment = comment;
    }
    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Writer getWriter() {
        return writer;
    }

    public void setWriter(Writer writer) {
        this.writer = writer;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "Id='" + Id + '\'' +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", content='" + content + '\'' +
                ", date=" + date +
                ", writer=" + writer +
                ", comment=" + comment +
                '}';
    }
}
