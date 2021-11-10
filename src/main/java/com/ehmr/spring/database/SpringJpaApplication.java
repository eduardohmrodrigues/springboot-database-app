package com.ehmr.spring.database;

import com.ehmr.spring.database.jpa.PersonJpaRepository;
import com.ehmr.spring.database.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class SpringJpaApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PersonJpaRepository personJpaRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringJpaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("FindAll: {}", personJpaRepository.findAll());
        logger.info("Id 10001: {}", personJpaRepository.findById(10001));
        personJpaRepository.deleteById(10002);
        logger.info("Insert New Person: {}", personJpaRepository.upsert(new Person("Bjorn", "Sweden", new Date())));
        logger.info("Updating 10003: {}", personJpaRepository.upsert(new Person(10003, "Pieter", "Denmark", new Date())));
    }
}
