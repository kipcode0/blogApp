package com.kipcode.blogapp.event;

import com.kipcode.blogapp.model.Writer;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

@Setter
@Getter
public class RegistrationCompleteEvent extends ApplicationEvent {

    private Writer writer;
    private String registrationUrl;

    public RegistrationCompleteEvent( Writer writer, String registrationUrl) {
        super(writer);
        this.writer = writer;
        this.registrationUrl = registrationUrl;
    }
}
