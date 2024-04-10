package com.aracely.jacinto.expenses.controller;

import com.aracely.jacinto.expenses.models.Person;
import com.aracely.jacinto.expenses.repository.PersonRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {
  private final PersonRepository personRepository;

  public PersonController(PersonRepository personRepository) {
    this.personRepository = personRepository;
  }

  @GetMapping("/people")
  public List<Person> findAllPeople() {
    return this.personRepository.findAll();
  }

  @PostMapping("/person")
  public Person addPerson(@RequestBody Person person) {
    return this.personRepository.save(person);
  }
}
