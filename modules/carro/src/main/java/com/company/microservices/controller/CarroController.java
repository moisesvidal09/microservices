package com.company.microservices.controller;

import com.company.microservices.entity.Carro;
import com.company.microservices.service.CarroService;
import com.company.microservices.service.SendEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        sendEventService.sendEvent("SaveCarro", carro);
        return new ResponseEntity<>(carroService.save(carro), HttpStatus.CREATED);
    }

}
