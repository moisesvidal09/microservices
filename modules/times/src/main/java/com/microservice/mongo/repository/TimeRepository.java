package com.microservice.mongo.repository;

import com.microservice.mongo.entidade.Time;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TimeRepository extends MongoRepository<Time, String> {

}
