package com.learn.hibernate6.model.dto;


import jakarta.persistence.Entity;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
public class OrderTupleForUserWithUserName extends OrderTupleForUser{
    String username;
}
