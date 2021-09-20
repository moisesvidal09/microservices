package com.microservice.mongo.service;

import com.microservice.mongo.entidade.Time;
import com.microservice.mongo.repository.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimeService {

    @Autowired
    private TimeRepository timeRepository;

    public Time cadastar(Time time){
        return timeRepository.save(time);
    }

    public List<Time> getAll(){
        return timeRepository.findAll();
    }

}
