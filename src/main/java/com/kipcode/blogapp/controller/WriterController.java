package com.kipcode.blogapp.controller;

import com.kipcode.blogapp.exceptions.ResourceNotFoundException;
import com.kipcode.blogapp.model.*;
import com.kipcode.blogapp.repository.BlogRepository;
import com.kipcode.blogapp.repository.WriterRepository;
import com.kipcode.blogapp.security.AuthentificationRequest;
import com.kipcode.blogapp.security.AuthentificationResponse;
import com.kipcode.blogapp.security.JwtUtil;
import com.kipcode.blogapp.service.BlogUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
public class WriterController {
    @Autowired
    private BlogRepository blogRepository;
    @Autowired
    private WriterRepository writerRepository;

    @Autowired
    JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    BlogUserDetailsService blogUserDetailsService;

    private ApplicationEventPublisher applicationEventPublisher;
    @GetMapping("/authors")
    public List<Writer> findWriters(){
        return writerRepository.findAll();
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(
            @RequestBody AuthentificationRequest authentificationRequest) throws Exception{
         try{
             authenticationManager.authenticate(
                     new UsernamePasswordAuthenticationToken(authentificationRequest.getEmail(), authentificationRequest.getPassword())
             );
         }catch (Exception e){
             throw new Exception("Incorrect username or password");

         }

         final  UserDetails userDetails = blogUserDetailsService.loadUserByUsername(authentificationRequest.getEmail());
         final Optional<Writer> writer = blogUserDetailsService.getUser(authentificationRequest.getEmail());
          Writer _writer = writer.get();


         final String jwt = jwtUtil.generateToken(userDetails);
         return ResponseEntity.ok(new AuthentificationResponse(jwt,_writer.getFirstName(),_writer.getLastName()));
    }

    /*
    * .map(UserRegistrationDetails::new)
                .orElseThrow(()->new UsernameNotFoundException("User Not found"));
    *
    *
    * */

     /*
    @PostMapping("/signup")
    public ResponseEntity<Writer> createBlog(@RequestBody Writer writer){
        try{
            Writer createdWriter = writerRepository.save(new Writer(writer.getFirstName(),writer.getLastName(),writer.getPassword(),writer.getEmail()));
            return new ResponseEntity<>(createdWriter, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    */

    @GetMapping("/find-writer/{id}")
    public ResponseEntity<Writer> getBlogById(@PathVariable Long id){
        Writer writer = writerRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Not found Blog with id = " + id));
        return new ResponseEntity<>(writer, HttpStatus.OK);
    }

    @DeleteMapping("/writer/delete/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") Long id) {
        try {
            writerRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
   



}
