package com.lob.springboot_api.dto;

import java.io.Serializable;

public class CreateForm implements Serializable {


    private String Id;
    private String name;
    private String Organ;
    private String Password;

    public String getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public String getOrgan() {
        return Organ;
    }

    public String getPassword() {
        return Password;
    }

    public void setId(String id) {
        Id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOrgan(String organ) {
        Organ = organ;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
