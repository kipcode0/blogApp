package com.kipcode.blogapp.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name="blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    Long Id;

    @Column(name = "title")
    private String title;

    @Column(name = "genre")
    private String genre;

    @Lob
    @Column(name = "content")
    private String content;

    @Column(name = "date")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date date;


    public Blog() {
        //default constructor
    }

    public Blog(String title, String genre, String content, Date date) {
        this.title = title;
        this.genre = genre;
        this.content = content;
        this.date = date;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        this.Id = id;
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
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", content='" + content + '\'' +
                ", date=" + date +
                '}';
    }
}