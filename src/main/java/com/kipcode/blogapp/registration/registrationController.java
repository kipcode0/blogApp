package com.kipcode.blogapp.registration;

import com.kipcode.blogapp.event.RegistrationCompleteEvent;
import com.kipcode.blogapp.model.Writer;
import com.kipcode.blogapp.registration.token.VerificationToken;
import com.kipcode.blogapp.repository.VerificationTokenRepository;
import com.kipcode.blogapp.service.WriterService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("/register")
public class registrationController {
    private final WriterService writerService;
    private final ApplicationEventPublisher publisher;
    private final VerificationTokenRepository tokenRepository;

    @PostMapping
    public String registerUser(@RequestBody Registration request, final HttpServletRequest requestServlet){
        Writer writer = writerService.registerWriter(request);
        publisher.publishEvent(new RegistrationCompleteEvent(writer, registrationUrl(requestServlet)));
        return "Success! Check your email to complete your registration";
    }
    public String registrationUrl(HttpServletRequest servletRequest){
        return "http://"+servletRequest.getServerName()+":"+servletRequest.getServerPort()+servletRequest.getContextPath();

    }

    @GetMapping("/verifyEmail")
    public String verifyEmail(@RequestParam("token") String token){
        VerificationToken  vToken = tokenRepository.findByToken(token);
        if(vToken.getWriter().isEnabled()){
            return "This account is already verified. Please login";
        }
        String verificationResult =  writerService.validateToken(token);
        if(verificationResult.equalsIgnoreCase("Valid!")){
            return "Email Verified successfully. Proceed with account Login";
        }
        return "Invalid Verification Token";
    }
    @DeleteMapping("/token/delete/{id}")
    public ResponseEntity<HttpStatus> deleteToken(@PathVariable("id") Long id) {
        try {
            tokenRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
