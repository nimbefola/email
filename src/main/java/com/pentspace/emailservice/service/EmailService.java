package com.pentspace.emailservice.service;

public interface EmailService {
    String sendEmail(String receiverEmail, String content, String title);
}
