package com.company.email.service;

import com.company.email.entity.Email;
import com.company.email.enums.StatusEmail;
import com.company.email.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmailService {

    @Autowired
    private EmailRepository emailRepository;

    @Autowired
    private JavaMailSender sender;

    public void sendEmail(Email email){

        email.setSendDateTime(LocalDateTime.now());

        try{

            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setFrom(email.getEmailFrom());
            simpleMailMessage.setTo(email.getEmailTo());
            simpleMailMessage.setSubject(email.getSubject());
            simpleMailMessage.setText(email.getText());
            sender.send(simpleMailMessage);

        } catch(MailException e) {

            email.setStatusEmail(StatusEmail.NOT_SENT);

        } finally {

            emailRepository.save(email);

        }

    }

}
