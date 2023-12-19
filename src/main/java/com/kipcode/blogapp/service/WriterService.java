package com.kipcode.blogapp.service;

import com.kipcode.blogapp.exceptions.WriterAlreadyExistsException;
import com.kipcode.blogapp.model.Writer;
import com.kipcode.blogapp.registration.Registration;
import com.kipcode.blogapp.registration.token.VerificationToken;
import com.kipcode.blogapp.repository.VerificationTokenRepository;
import com.kipcode.blogapp.repository.WriterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor  //any field not marked as final will not be autowired
public class WriterService implements IWriterService{
    private final WriterRepository writerRepository;
    private final PasswordEncoder passwordEncoder;
    private final VerificationTokenRepository verificationTokenRepository;


    @Override
    public List<Writer> getWriters() {
       return writerRepository.findAll();
    }

    @Override
    public Writer registerWriter(Registration request) {
        //before registering writer find if they exist
        Optional<Writer> writer = writerRepository.findByEmail(request.getEmail());
        if(writer.isPresent()){
            throw new WriterAlreadyExistsException("User with email " + request.getEmail() + "already exists");
        }
        Writer newWriter = new Writer();
        newWriter.setFirstName(request.getFirstName());
        newWriter.setLastName(request.getLastName());
        newWriter.setEmail(request.getEmail());
        newWriter.setPassword(passwordEncoder.encode(request.getPassword()));
        newWriter.setRole(request.getRole());
        return writerRepository.save(newWriter);
    }

    @Override
    public Optional<Writer> findByEmail(String email) {
        return writerRepository.findByEmail(email);
    }

    @Override
    public void saveWriterVerificationToken(Writer writer, String verificationToken) {
        VerificationToken verificationToken1 = new VerificationToken(verificationToken, writer);
        verificationTokenRepository.save(verificationToken1);
    }

    @Override
    public String validateToken(String token) {
        VerificationToken savedToken = verificationTokenRepository.findByToken(token);
        if(token==null){
            return "Invalid Verification Token";
        }
        Writer writer = savedToken.getWriter();
        Calendar calendar = Calendar.getInstance();
        if(savedToken.getTokenExpirationTime().getTime() - calendar.getTime().getTime() <= 0){
            verificationTokenRepository.delete(savedToken);
            return "Token already expired";
        }
        writer.setEnabled(true);
        writerRepository.save(writer);
        return "Valid!";
    }


}
