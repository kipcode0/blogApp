package com.kipcode.blogapp.service;

import com.kipcode.blogapp.model.Writer;
import com.kipcode.blogapp.repository.WriterRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Queue;

public class WriterServiceImpl implements WriterService{
    private WriterRepository writerRepository;
    @Override
    public Writer saveWriter(Writer writer) {
        return  writerRepository.save(writer);
    }

}
