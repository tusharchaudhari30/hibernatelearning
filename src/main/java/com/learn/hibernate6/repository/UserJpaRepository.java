package com.learn.hibernate6.repository;

import com.learn.hibernate6.model.dao.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<User, Integer> {
}
