package com.bakerygb.bgbapp.models;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

/*
Spring Data JPA & Hibernate
 */

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "Users")
public class User {

    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "sequence_user",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long id;
    private String name;
    private String username;
    private String email;
    private String password;

    //@ManyToMany
    private String role;

    public User(String name, String username, String email, String password, String role) {

        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
    }

}
