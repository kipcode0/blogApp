package com.kipcode.blogapp.event.listener;

import com.kipcode.blogapp.event.RegistrationCompleteEvent;
import com.kipcode.blogapp.model.Writer;
import com.kipcode.blogapp.service.WriterService;
import com.sun.xml.internal.org.jvnet.mimepull.MIMEMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.UUID;
@Slf4j
@Component
@RequiredArgsConstructor
public class registrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent> {
    private final WriterService writerService;
    private final JavaMailSender javaMailSender;
    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        //Get newly registered user
        Writer writer = event.getWriter();
        //Create verification token for the writer
        String verificationToken = UUID.randomUUID().toString();
        //Save the verification token for the writer
        writerService.saveWriterVerificationToken(writer, verificationToken);
        //create verification url to be sent to user
        String url = event.getRegistrationUrl() + "/register/verifyEmail?token="+verificationToken;
        //send email to user
        try {
            sendVerificationEmail(url,writer);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        //log.info("Click link to complete registration: {}", url);
    }

    public void sendVerificationEmail(String emailUrl, Writer writer) throws MessagingException, UnsupportedEncodingException {
        String subject = "Email Verification";
        String senderName = "InscriberPost";
        String mailContent =  "<p> Hi, "+ writer.getFirstName() + "</p>\n" +
                "<p> Thank you for registering with us, "+""
                +  "Please click the link below to complete registration.</p>" +
                "<a href=\"" +emailUrl+  "\">Verify your email to activate your account</a>"+
                "<p>Thank you <br> InscriberPost";
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message);
        mimeMessageHelper.setFrom("kipcode0@gmail.com", senderName);
        mimeMessageHelper.setTo(writer.getEmail());
        mimeMessageHelper.setSubject(subject);
        mimeMessageHelper.setText(mailContent,true);
        javaMailSender.send(message);
    }
}
