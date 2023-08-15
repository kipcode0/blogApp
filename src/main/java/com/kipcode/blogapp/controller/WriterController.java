package com.kipcode.blogapp.controller;

import com.kipcode.blogapp.exceptions.ResourceNotFoundException;
import com.kipcode.blogapp.model.Blog;
import com.kipcode.blogapp.model.Writer;
import com.kipcode.blogapp.repository.BlogRepository;
import com.kipcode.blogapp.repository.WriterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/blogs")
public class WriterController {
    @Autowired
    private BlogRepository blogRepository;
    @Autowired
    private WriterRepository writerRepository;

    @GetMapping("/authors")
    public List<Writer> findWriters(){
        return writerRepository.findAll();
    }

    @PostMapping("/signup")
    public ResponseEntity<Writer> createBlog(@RequestBody Writer writer){
        try{
            Writer createdWriter = writerRepository.save(new Writer(writer.getFirstName(),writer.getLastName(),writer.getPassword(),writer.getEmail()));
            return new ResponseEntity<>(createdWriter, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @GetMapping("/find-writer/{id}")
    public ResponseEntity<Writer> getBlogById(@PathVariable Long id){
        Writer writer = writerRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Not found Blog with id = " + id));
        return new ResponseEntity<>(writer, HttpStatus.OK);
    }


}
