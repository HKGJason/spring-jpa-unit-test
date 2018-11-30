package com.oocl.web.sampleWebApp;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SingleEntity {
    @Id
    private Long id;
    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
