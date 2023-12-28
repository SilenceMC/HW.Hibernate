package com.example.hibernate.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
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
