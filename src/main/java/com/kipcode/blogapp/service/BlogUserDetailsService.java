package com.kipcode.blogapp.service;

import com.kipcode.blogapp.model.Writer;
import com.kipcode.blogapp.repository.WriterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class BlogUserDetailsService implements UserDetailsService {
    @Autowired
    WriterRepository writerRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            Writer writer = writerRepository.findByEmail(username);
            return new User(writer.getEmail(),writer.getPassword(),new ArrayList<>());
    }


    public Writer getUser(String email){
        return writerRepository.findByEmail(email);
    }
}

