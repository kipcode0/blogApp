package com.kipcode.blogapp.model;

import net.minidev.json.annotate.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="writer")
public class Writer {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int Id;

    @Column(name = "first_name",nullable = false)
    private String firstName;

    @Column(name="last_name", nullable = false)
    private String lastName;

    @Column(name= "password",nullable = false)
    private String password;

    @Column(name="email", nullable = false)
    private String email;

    @OneToMany(targetEntity = Blog.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "writer_detail_id", referencedColumnName ="Id", nullable = true)
    @JsonIgnore
    private List<Blog> blogs;

    public Writer() {
    }

    public Writer(int id, String firstName, String lastName, String email, List<Blog> blogs) {
        Id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.blogs = blogs;
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
                "Id=" + Id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", blogs=" + blogs +
                '}';
    }
}
