package com.kipcode.dto;

import com.kipcode.blogapp.model.Writer;

public class WriterRequest {
    private Writer writer;

    public WriterRequest() {
    }

    public WriterRequest(Writer writer) {
        this.writer = writer;
    }

    public Writer getWriter() {
        return writer;
    }

    public void setWriter(Writer writer) {
        this.writer = writer;
    }

    @Override
    public String toString() {
        return "WriterRequest{" +
                "writer=" + writer +
                '}';
    }
}
