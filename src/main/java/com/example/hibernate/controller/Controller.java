package com.example.hibernate.controller;

import com.example.hibernate.entity.Person;
import com.example.hibernate.repository.Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class Controller {
    private final Repository repository;

    @GetMapping("/persons/by-city")
    public ResponseEntity<List<Person>> getPersonsByCity(@RequestParam String city) {
        return ResponseEntity.ok(repository.getPersonsByCity(city));
    }
}
