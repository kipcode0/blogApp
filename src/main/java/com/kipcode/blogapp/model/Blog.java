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
    private int Id;
    private String title;
    private String genre;
    private String content;
    private Date date;



    public Blog(){
        //default constructor
    }
    public Blog(int id, String title, String genre, String content, Date date) {
        Id = id;
        this.title = title;
        this.genre = genre;
        this.content = content;
        this.date = date;
    }
    public int getId() {
        return Id;
    }

    public void setId(int id) {
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


    @Override
    public String toString() {
        return "Blog{" +
                "Id=" + Id +
                ", title=" + title +
                ", genre=" + genre +
                ", content=" + content +
                ", date=" + date +
                '}';
    }
}
