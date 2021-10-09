package com.bridgelabz.greetingappproblem.repository;

import com.bridgelabz.greetingappproblem.model.Greetings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GreetingRepository extends JpaRepository<Greetings, Integer> {
}
