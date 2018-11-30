package com.oocl.web.sampleWebApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    SingleEntityService singleEntityService;
    @Autowired
    public Controller(SingleEntityService singleEntityService){
        this.singleEntityService = singleEntityService;
    }
    @GetMapping
    String getCompanyByIndex(){
        return "Hi";
    }

}

