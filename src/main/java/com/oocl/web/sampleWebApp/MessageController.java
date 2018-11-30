package com.oocl.web.sampleWebApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.plugin2.message.Message;

@RestController
public class MessageController {
    @Autowired
    public MessageController(){
    }
    @Autowired
    private SingleEntityRepository singleEntityRepository;

    @GetMapping(value = "/message")
    public ResponseEntity<MessageResponse> get(){
        return new ResponseEntity<>(new MessageResponse("Hi"), HttpStatus.OK);
    }

    @GetMapping(value = "/singleentity")
    public SingleEntity getEntity(){
        return singleEntityRepository.findAll().get(0);
    }
}

