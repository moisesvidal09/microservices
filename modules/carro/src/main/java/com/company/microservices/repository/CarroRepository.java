package com.company.microservices.repository;

import com.company.microservices.entity.Carro;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CarroRepository extends MongoRepository<Carro, String> {
}
