package com.learn.hibernate6.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "Users")
/**
 * 
 * @author blaze
 *
 */
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