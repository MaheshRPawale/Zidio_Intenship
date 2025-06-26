package com.zidio.zidioconnect.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.zidio.zidioconnect.dto.EmailRequestDto;


@Service
public class EmailServiceImpl {

    @Autowired
    private JavaMailSender mailSender;

    public String sendEmail(EmailRequestDto request) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(request.getTo());
        message.setSubject(request.getSubject());
        message.setText(request.getMessage());
        message.setFrom("maheshpawale018@gmail.com"); //  actual sender email

        mailSender.send(message);
        return "Email sent successfully!";
    }
}
