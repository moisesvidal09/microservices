package com.company.microservices.controller;

import com.company.microservices.entity.Carro;
import com.company.microservices.entity.Email;
import com.company.microservices.service.CarroService;
import com.company.microservices.service.SendEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CarroController {

    @Autowired
    private CarroService carroService;

    @Autowired
    private SendEventService sendEventService;

    @GetMapping
    public ResponseEntity<List<Carro>> getList(){
        return new ResponseEntity<>(carroService.getList(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Carro> save(@RequestBody Carro carro){

        Email email = Email.builder()
                            .ownerRef("Moisés")
                            .emailFrom("moisesvidal09@gmail.com")
                            .emailTo("moisesrok@gmail.com")
                            .subject("Test Email Microservice")
                            .text("Hi, this email was sent by an microservice with Apache Kafka")
                            .build();

        sendEventService.sendEvent("SendMail", email);

        return new ResponseEntity<>(carroService.save(carro), HttpStatus.CREATED);
    }

}
