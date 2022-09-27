package com.example.JenkinsDemo.Entity;

import lombok.Builder;

import javax.persistence.Entity;
import javax.persistence.Id;



@Entity
@Builder
public class Users {

    @Id
    int id;
    String name;
    String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Users(int id, String email,String name) {
        this.id = id;
        this.email = email;
        this.name=name;
    }

    public Users() {
    }
}

