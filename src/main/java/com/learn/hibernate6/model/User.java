package com.learn.hibernate6.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
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
	private Integer userId;

	private Name name;

	private String username;

	private String email;

	@JsonIgnore
	private String password;

	private LocalDateTime createdAt;

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