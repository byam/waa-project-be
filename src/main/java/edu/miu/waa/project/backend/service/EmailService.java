package edu.miu.waa.project.backend.service;

public interface EmailService {
    void send(String to, String subject, String body);

    void sendWithHTMLBody(String to, String subject, String body);
}
