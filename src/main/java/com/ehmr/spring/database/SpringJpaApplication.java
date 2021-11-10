package com.ehmr.spring.database;

import com.ehmr.spring.database.jpa.PersonJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
//        logger.info("FindAll: {}", personDAO.findAll());
        logger.info("Id 10001: {}", personJpaRepository.findById(10001));
//        logger.info("Delete 10003. Number of people deleteById: {}", personDAO.deleteById(10003));
//        logger.info("Insert 10004: {}", personDAO.insert(new Person(10004, "Bjorn", "Sweden", new Date())));
//        logger.info("Updating 10003: {}", personDAO.update(new Person(10002, "James", "Denmark", new Date())));
    }
}
