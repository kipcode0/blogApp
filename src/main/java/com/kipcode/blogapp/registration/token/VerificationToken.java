package com.kipcode.blogapp.registration.token;

import com.kipcode.blogapp.model.Writer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;
@Getter
@Setter
@Entity
@NoArgsConstructor
public class VerificationToken {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String token;
    private Date expirationTime;
    @OneToOne
    @JoinColumn(name="writer_detail_id")
    private Writer writer;

    public VerificationToken(String token,Writer writer) {
        //super
        this.token = token;
        this.writer = writer;
        this.expirationTime = this.getTokenExpirationTime();
    }
    public VerificationToken(String token) {
        //super
        this.token = token;
        this.expirationTime = this.getTokenExpirationTime();
    }

    public Date getTokenExpirationTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(new Date().getTime());
        calendar.add(Calendar.MINUTE,30);
        return new Date(calendar.getTime().getTime());
    }
}
