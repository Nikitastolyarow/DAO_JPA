package ru.netology.hibernate_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.netology.hibernate_app.entity.Person;
import ru.netology.hibernate_app.entity.PersonID;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, PersonID> {

    List<Person> findByCityOfLiving(String city);

    List<Person> findById_AgeLessThan(int age);

    Optional<Person> findById_NameAndId_Surname(String name, String surname);

}