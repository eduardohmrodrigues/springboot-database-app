package com.ehmr.spring.database.springdata;

import com.ehmr.spring.database.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonSpringDataRepository extends JpaRepository<Person, Integer> {
}
