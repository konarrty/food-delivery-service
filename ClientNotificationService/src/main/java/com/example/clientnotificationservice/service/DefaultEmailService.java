package com.example.clientnotificationservice.service;

import jakarta.activation.FileDataSource;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

@Service
@RequiredArgsConstructor
public class DefaultEmailService implements EmailService {

    private final JavaMailSender emailSender;

    @Value("${email}")
    private String email;

    @Override
    public void sendSimpleEmail(String toAddress, String subject, String message) {

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(toAddress);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(message);
        simpleMailMessage.setFrom(email);
        emailSender.send(simpleMailMessage);

    }

    @Override
    public void sendEmailWithAttachment(String toAddress, String subject, String message, String attachment) throws IOException, MessagingException {

        MimeMessage mimeMessage = emailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage,
                MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                StandardCharsets.UTF_8.name());
        messageHelper.setTo(toAddress);
        messageHelper.setFrom(email);
        messageHelper.setSubject(subject);
        messageHelper.setText(new ClassPathResource("email.html").getContentAsString(Charset.defaultCharset()), true);

        emailSender.send(messageHelper.getMimeMessage());

    }
}