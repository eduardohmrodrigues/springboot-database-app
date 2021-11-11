package com.ehmr.spring.database;

import com.ehmr.spring.database.jpa.PersonJpaRepository;
import com.ehmr.spring.database.model.Person;
import com.ehmr.spring.database.springdata.PersonSpringDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PersonSpringDataRepository personSpringDataRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringDataApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("FindAll: {}", personSpringDataRepository.findAll());
        logger.info("Id 10001: {}", personSpringDataRepository.findById(10001));
        personSpringDataRepository.deleteById(10002);
        logger.info("Insert New Person: {}", personSpringDataRepository.save(new Person("Bjorn", "Sweden", new Date())));
        logger.info("Updating 10003: {}", personSpringDataRepository.save(new Person(10003, "Pieter", "Denmark", new Date())));
    }
}
