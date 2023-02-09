package edu.miu.waa.project.backend.service.impl;

import edu.miu.waa.project.backend.domain.User;
import edu.miu.waa.project.backend.service.EmailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import lombok.Builder;
import lombok.Data;

import java.io.UnsupportedEncodingException;
@Service
@Data
@Builder
public class EmailServiceImpl implements EmailService {
    private static final String SENDER_EMAIL = "waaprojectfinal@gmail.com";
    private final JavaMailSender javaMailSender;




    @Override
    public void send(String to, String subject, String body) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(SENDER_EMAIL);
            message.setTo(to);
            message.setSubject(subject);
            message.setText(body);
            javaMailSender.send(message);
            System.out.println("Mail is sucssesful");

        } catch (MailException mailException) {
            mailException.printStackTrace();
        }
    }

    @Override
    public void sendWithHTMLBody(String to, String subject, String body) {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message);

        try {
            mimeMessageHelper.setFrom(SENDER_EMAIL, "WAA FINAL");
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setText(body, true);

            javaMailSender.send(message);

        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


    }
}
