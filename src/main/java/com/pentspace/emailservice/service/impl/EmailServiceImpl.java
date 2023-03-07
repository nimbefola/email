package com.pentspace.emailservice.service.impl;

import com.pentspace.emailservice.service.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmailServiceImpl implements EmailService {
    @Value("${spring.mail.username}")
    private String sender;
    @Autowired
    private JavaMailSender javaMailSender;
    @Override
    public String sendEmail(String receiverEmail, String content, String title) {
        try{
            log.info( title + "notification request for [{}]", receiverEmail);
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setFrom(sender);
            simpleMailMessage.setTo(receiverEmail);
            simpleMailMessage.setText(content);
            simpleMailMessage.setSubject(title);
            javaMailSender.send(simpleMailMessage);
            log.info(" Email sent successfully ");
            return "Email sent successfully";
        }catch (Exception e){
            log.info("Error occurred While Sending Mail [{}]", e.getMessage());
            return " An error occurred sending email ";
        }
    }

}
