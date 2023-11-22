package com.example.clientnotificationservice.service;

import jakarta.mail.MessagingException;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface EmailService {
    void sendSimpleEmail(String toAddress, String subject, String message);

    void sendEmailWithAttachment(String toAddress, String subject, String message, String attachment) throws MessagingException, IOException, MessagingException;
}
