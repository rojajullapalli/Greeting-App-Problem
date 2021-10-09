package com.bridgelabz.greetingappproblem.service;

import com.bridgelabz.greetingappproblem.dto.GreetingsDto;
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

    public Greetings getGreetingById(int id) {
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

    public Greetings addGreeting(GreetingsDto greetings) {
        Greetings greetingsEntity = new Greetings();
        greetingsEntity.setMessage(greetings.getMessage());
        return greetingRepository.save(greetingsEntity);
    }

    public List<Greetings> greetings() {
        return greetingRepository.findAll();
    }

    public Greetings updateGreeting(int id, GreetingsDto greetingsDto) {
        Optional<Greetings> optionalGreetingEntity = greetingRepository.findById(id);
        if(optionalGreetingEntity.isPresent()) {
            Greetings greetings = optionalGreetingEntity.get();
            greetings.setMessage(greetingsDto.getMessage());
            return greetingRepository.save(greetings);
        }
        return null;
    }

    public String deleteGreeting(int id) {
        Optional<Greetings> greetingModel = greetingRepository.findById(id);
       if(greetingModel.isPresent()){
           greetingRepository.delete(greetingModel.get());
           return "Record Deleted Successfully";
       }
       return "Record Does Not Exists with id: "+id;
    }
}
