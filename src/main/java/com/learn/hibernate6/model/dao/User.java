package com.learn.hibernate6.model.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "Users")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    private Name name;

    private String username;

    private String email;

    @JsonIgnore
    private String password;

    private LocalDateTime createdAt;

    @Column(insertable = false, updatable = false)
    private String completeName;

}

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Embeddable
class Name {

    private String first;

    private String last;

    private String middle;
}