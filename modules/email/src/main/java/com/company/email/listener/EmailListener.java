package com.company.email.listener;

import com.company.email.entity.Email;
import com.company.email.service.EmailService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EmailListener {

    @Autowired
    private EmailService emailService;

    @KafkaListener(topics = "SendMail", groupId = "MicroserviceSaveCarro")
    private void exec(ConsumerRecord<String, String> record){

        log.info("Chave = {}", record.key());
        log.info("Cabecalho = {}", record.headers());
        log.info("Particao = {}", record.partition());

        String strDados = record.value();

        ObjectMapper mapper = new ObjectMapper();

        Email email;

        try {
            email = mapper.readValue(strDados, Email.class);
            emailService.sendEmail(email);
        } catch (JsonProcessingException ex) {
            log.error("Falha converter evento [dado={}}]", strDados, ex);
            return;
        }

        log.info("Evento Recebido = {}", email);
    }

}
