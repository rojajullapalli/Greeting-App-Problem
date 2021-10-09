package com.bridgelabz.greetingappproblem.service;

import com.bridgelabz.greetingappproblem.model.GreetingModel;
import com.bridgelabz.greetingappproblem.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GreetingService {
    @Autowired
    GreetingRepository greetingRepository;

    public GreetingModel getStudentById(int id) {
        Optional<GreetingModel> greetingModel = greetingRepository.findById(id);
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

    public GreetingModel addGreeting(GreetingModel greetingModel) {
        return greetingRepository.save(greetingModel);
    }
}
