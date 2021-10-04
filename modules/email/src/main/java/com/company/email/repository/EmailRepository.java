package com.company.email.repository;

import com.company.email.entity.Email;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmailRepository extends MongoRepository<Email, String> {
}
