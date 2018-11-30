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

    @GetMapping
    public ResponseEntity<MessageResponse> get(){
        return new ResponseEntity<>(new MessageResponse("Hi"), HttpStatus.OK);
    }

}

