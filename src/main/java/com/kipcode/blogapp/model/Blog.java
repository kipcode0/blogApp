package com.kipcode.blogapp.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import net.minidev.json.annotate.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
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

    @ManyToOne
    @JoinColumn(name ="writer_detail_id", nullable = true)
    private Writer writer;
    @Column(name = "date")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date date;


    public Blog() {
        //default constructor
    }

    public Blog(String title, String genre, String content, Writer writer, Date date) {
        this.title = title;
        this.genre = genre;
        this.content = content;
        this.writer = writer;
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
    public Writer getWriter() {
        return writer;
    }
    public void setWriter(Writer writer) {
        this.writer = writer;
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
                ", writer =" + writer.getLastName() +
                '}';
    }
}