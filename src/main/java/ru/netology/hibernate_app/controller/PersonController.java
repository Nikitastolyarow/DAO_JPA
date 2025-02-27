package ru.netology.hibernate_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.netology.hibernate_app.entity.Person;
import ru.netology.hibernate_app.service.PersonService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persons")
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/by-city")
    public List<Person> getPersonsByCity(@RequestParam String city) {
        return personService.getPersonByCity(city);
    }

    @GetMapping("/age")
    public List<Person> getPersonsByAge(@RequestParam int age) {
        return personService.getPersonByAge(age);
    }

    @GetMapping("/by-name-surname")
   public ResponseEntity<Person> getPersonByNameSurname(@RequestParam String name , @RequestParam String surname) {
        Optional<Person> person = personService.getPersonByNameAndSurname(name, surname);
        return person.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

}
