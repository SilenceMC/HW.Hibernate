package com.example.hibernate.entity;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@NoArgsConstructor
public class PersonId implements Serializable {
    private String name;
    private String surname;
    private int age;
}
