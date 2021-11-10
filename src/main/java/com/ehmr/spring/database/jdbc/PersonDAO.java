package com.ehmr.spring.database.jdbc;

import com.ehmr.spring.database.model.Person;
import com.ehmr.spring.database.rowmappers.PersonRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

@Repository
public class PersonDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Person> findAll() {
        return jdbcTemplate.query("select * from person",
                new PersonRowMapper());
    }

    public Person findById(int id) {
        return (Person) jdbcTemplate.queryForObject("select * from person where id=?",
                new PersonRowMapper(), id);
    }

    public int insert(Person person) {
        return jdbcTemplate.update("insert into person (id, name, location, birth_date) values (?, ?, ?, ?)",
                person.getId(), person.getName(), person.getLocation(), new Timestamp(person.getBirthDate().getTime()));
    }

    public int update(Person person) {
        return jdbcTemplate.update("update person set name=?, location=?, birth_date=? where id=?",
                person.getName(), person.getLocation(), new Time(person.getBirthDate().getTime()), person.getId());
    }

    public int deleteById(int id) {
        return jdbcTemplate.update("delete from person where id=?", id);
    }
}
