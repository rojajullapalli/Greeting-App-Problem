package com.bridgelabz.greetingappproblem.repository;

import com.bridgelabz.greetingappproblem.model.GreetingModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
@Repository
public interface GreetingRepository extends JpaRepository<GreetingModel, Integer> {
}
