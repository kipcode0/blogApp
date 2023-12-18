package com.kipcode.blogapp.model;

//import net.minidev.json.annotate.JsonIgnore;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="writer")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Writer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "password", nullable = false)
    @JsonIgnore
    private String password;
    @Column(name = "email", nullable = false)
    @JsonIgnore
    @NaturalId(mutable = true)  //to be able to update email
    private String email;
    @OneToMany(targetEntity = Blog.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "writer_detail_id", referencedColumnName = "Id", nullable = true)
    @JsonIgnore
    private List<Blog> blogs;
    private String role;
    private boolean isEnabled = false;

}