package com.example.hibernate.repository;

import com.example.hibernate.entity.Person;
import com.example.hibernate.entity.PersonId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, PersonId> {
    List<Person> findByCityOfLiving(String city);

    List<Person> findByAgeLessThanOrderByAge (int age);

    Optional<Person> findByNameAndSurname(String name, String surname);
}
