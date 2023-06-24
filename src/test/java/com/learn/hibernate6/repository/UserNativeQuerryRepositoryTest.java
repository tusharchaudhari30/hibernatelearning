package com.learn.hibernate6.repository;

import com.learn.hibernate6.environment.TestingEnvironment;
import com.learn.hibernate6.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class UserNativeQuerryRepositoryTest {

    @Autowired
    UserNativeQuerryRepository userNativeQuerryRepository;

    @Autowired
    UserJpaRepository userJpaRepository;

    @Autowired
    TestingEnvironment testingEnvironment;

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }


    @Test
    void getListOfUsers() {
        testingEnvironment.setUpTesting();
        userNativeQuerryRepository.getListOfUsers().forEach(user -> System.out.println(user.getEmail()));
    }

    @Test
    void getPurchaceHistoryOfUser() {
        userNativeQuerryRepository.getListOfUsers().forEach(user -> System.out.println(user.getEmail()));
    }
}