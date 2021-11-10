package com.ehmr.spring.database;

import com.ehmr.spring.database.jdbc.PersonDAO;
import com.ehmr.spring.database.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import 	org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

//@SpringBootApplication
public class SpringJdbcApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonDAO personDAO;

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("FindAll: {}", personDAO.findAll());
		logger.info("Id 10001: {}", personDAO.findById(10001));
		logger.info("Delete 10003. Number of people deleted: {}", personDAO.deleteById(10003));
		logger.info("Insert 10004: {}", personDAO.insert(new Person(10004, "Bjorn", "Sweden", new Date())));
		logger.info("Updating 10003: {}", personDAO.update(new Person(10002, "James", "Denmark", new Date())));
	}
}
