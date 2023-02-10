package com.kipcode.blogapp.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Writer {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int Id;
    private String firstName;
    private String lastName;
    private String email;
    @OneToMany(targetEntity = Blog.class, cascade = CascadeType.ALL)
    @JoinColumn(name="writer_detail_id", referencedColumnName = "Id")
    List<Blog> blogs;


    public Writer() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }

    @Override
    public String toString() {
        return "Writer{" +
                "Id='" + Id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", blogs=" + blogs +
                '}';
    }
}
