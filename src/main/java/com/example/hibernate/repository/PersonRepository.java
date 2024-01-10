package com.example.hibernate.repository;

import com.example.hibernate.entity.Person;
import com.example.hibernate.entity.PersonId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, PersonId> {
    @Query(value = "select p from Person p where p.cityOfLiving = ?1")
    List<Person> findByCity(String city);

    @Query(value = "select p from Person p where p.age < ?1 order by p.age")
    List<Person> findByAgeLessThanOrderByAge (int age);

    @Query(value = "select p from Person p where p.name = ?1 and p.surname = ?2")
    Optional<Person> findByNameAndSurname(String name, String surname);
}
