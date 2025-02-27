package ru.netology.hibernate_app.entity;

//import jakarta.persistence.*;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

//schema = "netology"
@Entity
@Table(name = "Person")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@ToString

public class Person {

    @EmbeddedId
    private PersonID id;

    @Column(length = 25,name = "phone_number",nullable = false)
    private String phoneNumber;

    @Column(length = 70,name = "city_of_living",nullable = false)
    private String cityOfLiving;
}

