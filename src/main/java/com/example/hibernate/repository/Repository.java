package com.example.hibernate.repository;

import com.example.hibernate.entity.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Repository
public class Repository {

    @PersistenceContext
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
    public List<Person> getPersonsByCity(String city) {
        return entityManager
                .createNativeQuery("select * from persons where city_of_living = :city order by surname")
                .setParameter("city", city).getResultList();
    }
}
