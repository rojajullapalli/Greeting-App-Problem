package com.bridgelabz.greetingappproblem.service;

import com.bridgelabz.greetingappproblem.dto.StudentDto;
import com.bridgelabz.greetingappproblem.model.Greetings;
import com.bridgelabz.greetingappproblem.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GreetingService {
    @Autowired
    GreetingRepository greetingRepository;

    public Greetings getStudentById(int id) {
        Optional<Greetings> greetingModel = greetingRepository.findById(id);
        if(greetingModel.isPresent()){
            return greetingModel.get();
        }
        return null;
    }

    public String getGreeting() {
        return "Hello World";
    }

    public String getGreetingWithName(String firstName, String lastName) {
            return firstName+" " +lastName;
    }

    public Greetings addGreeting(StudentDto greetings) {
        Greetings greetingsEntity = new Greetings();
        greetingsEntity.setMessage(greetings.getMessage());
        return greetingRepository.save(greetingsEntity);
    }

    public List<Greetings> greetings() {
        return greetingRepository.findAll();
    }
}
