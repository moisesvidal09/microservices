package com.microservice.mongo.controller;

import com.microservice.mongo.entidade.Jogador;
import com.microservice.mongo.service.JogadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("jogador")
public class JogadorController {

    @Autowired
    private JogadorService jogadorService;

    @GetMapping
    public ResponseEntity<List<Jogador>> getAll(){
        return  new ResponseEntity<>(jogadorService.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Jogador> cadastrar(@RequestBody Jogador jogador){
        return new ResponseEntity<>(jogadorService.cadastrar(jogador), HttpStatus.OK);
    }

}
