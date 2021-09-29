package com.company.microservices.service;

import com.company.microservices.entity.Carro;
import com.company.microservices.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;

    public Carro save(Carro carro){
        return carroRepository.save(carro);
    }

    public List<Carro> getList(){
        return carroRepository.findAll();
    }

}
