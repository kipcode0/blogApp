package com.kipcode.blogapp.controller;

import com.kipcode.blogapp.model.Writer;
import com.kipcode.blogapp.repository.BlogRepository;
import com.kipcode.blogapp.repository.WriterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/blog")
public class WriterController {
    @Autowired
    private BlogRepository blogRepository;
    @Autowired
    private WriterRepository writerRepository;

    @GetMapping("/authors")
    public List<Writer> findWriters(){
        return writerRepository.findAll();
    }

}
