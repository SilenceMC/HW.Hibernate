package com.example.hibernate.repository;

import com.example.hibernate.entity.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PersonRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
    public List<Person> getPersonsByCity(String city) {
        return entityManager
                .createQuery("select p from Person p where p.cityOfLiving = :city order by p.personKey.surname")
                .setParameter("city", city).getResultList();
    }
}
