package com.example.jpaDemo.repository;


import com.example.jpaDemo.model.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {
}
