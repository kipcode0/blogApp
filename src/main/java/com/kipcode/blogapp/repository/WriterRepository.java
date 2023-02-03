package com.kipcode.blogapp.repository;

import com.kipcode.blogapp.model.Writer;
import org.springframework.data.repository.CrudRepository;

public interface WriterRepository extends CrudRepository<Writer, Integer> {
}
