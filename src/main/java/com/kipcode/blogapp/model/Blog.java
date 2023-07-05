package com.kipcode.blogapp.model;

import net.minidev.json.annotate.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "genre")
    private String genre;

    @Lob
    @Column(name = "content")
    private String content;

    @Column(name = "date")
    private Date date;


    public Blog() {
        //default constructor
    }

    public Blog(int id, String title, String genre, String content, Date date) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.content = content;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        id = id;
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
                "Id=" + id +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", content='" + content + '\'' +
                ", date=" + date +
                '}';
    }
}