package com.learn.hibernate6.environment;

import com.learn.hibernate6.model.dao.User;
import com.learn.hibernate6.repository.UserJpaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

@Service
public class TestingEnvironment {
    final
    UserJpaRepository userJpaRepository;

    @PersistenceContext
    EntityManager entityManager;


    public TestingEnvironment(UserJpaRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }

    public void setUpTesting() {
        User user1 = User.builder().email("tushar").build();
        userJpaRepository.save(user1);
        entityManager.unwrap(Session.class).createMutationQuery("");
    }
}
