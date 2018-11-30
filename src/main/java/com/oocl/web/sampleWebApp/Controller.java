package com.oocl.web.sampleWebApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.plugin2.message.Message;

@RestController
public class Controller {
    @Autowired
    public Controller(){
    }
    @GetMapping
    public MessageResponse getCompanyByIndex(){
        return new MessageResponse("Hi");
    }

}

