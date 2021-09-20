package com.microservice.mongo.service;

import com.microservice.mongo.entidade.Jogador;
import com.microservice.mongo.repository.JogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JogadorService {

    @Autowired
    private JogadorRepository jogadorRepository;

    public Jogador cadastrar(Jogador jogador){
        return jogadorRepository.save(jogador);
    }

    public List<Jogador> getAll(){
        return jogadorRepository.findAll();
    }

}
