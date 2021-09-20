package com.microservice.mongo.repository;

import com.microservice.mongo.entidade.Jogador;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JogadorRepository extends MongoRepository<Jogador, String> {
}
