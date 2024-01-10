package com.example.hibernate.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@IdClass(PersonId.class)
@Table(name = "PERSONS")
public class Person {

    @Id
    private String name;

    @Id
    private String surname;

    @Id
    private int age;

    private String phoneNumber;

    private String cityOfLiving;
}
