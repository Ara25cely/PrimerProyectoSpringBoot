package com.aracely.jacinto.expenses.repository;

import com.aracely.jacinto.expenses.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> { }
