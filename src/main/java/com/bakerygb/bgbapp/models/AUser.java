package com.bakerygb.bgbapp.models;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class AUser {

    @Id
    Long id;
    String name;
    String email;
    String password;

    public AUser(){
        id = 0l;
        name = "pUser";
        email ="none@email.com";
        password = "";
    }



}
