package com.kipcode.blogapp.service;


import com.kipcode.blogapp.model.Writer;
import com.kipcode.blogapp.registration.Registration;
import com.kipcode.blogapp.registration.token.VerificationToken;

import java.util.List;
import java.util.Optional;

public interface IWriterService {
    public List<Writer> getWriters();
    Writer registerWriter(Registration request);
    Optional<Writer> findByEmail(String email);

    void saveWriterVerificationToken(Writer writer, String verificationToken);
    String validateToken(String token);
}
