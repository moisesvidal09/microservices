package com.microservice.mongo.controller;

import com.microservice.mongo.entidade.Time;
import com.microservice.mongo.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("time")
public class TimeController {

    @Autowired
    private TimeService timeService;

    @GetMapping
    public ResponseEntity<List<Time>> getAll(){
        return new ResponseEntity<>(timeService.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Time> cadastrar(@RequestBody Time time){
        return new ResponseEntity<>(timeService.cadastar(time), HttpStatus.OK);
    }

}
