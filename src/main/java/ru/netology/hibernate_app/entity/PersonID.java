package ru.netology.hibernate_app.entity;

//import jakarta.persistence.Column;
//import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class PersonID implements Serializable {

    @Column(length = 30, name = "name",nullable = false)
    private String name;

    @Column(length = 30, name = "surname",nullable = false)
    private String surname;

    @Column(length = 3, name = "age",nullable = false)
    private int age;
}
