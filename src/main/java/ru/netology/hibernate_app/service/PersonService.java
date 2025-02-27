package ru.netology.hibernate_app.service;

import org.springframework.stereotype.Service;
import ru.netology.hibernate_app.entity.Person;
import ru.netology.hibernate_app.repository.PersonRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    public List<Person> getPersonByCity(String city) {
        return personRepository.findByCityOfLiving(city);
    }

    public List<Person> getPersonByAge(int age) {
        return personRepository.findById_AgeLessThan(age);
    }

    public Optional<Person> getPersonByNameAndSurname(String name, String surname) {
        return personRepository.findById_NameAndId_Surname(name, surname);
    }
}
