package com.bridgelabz.greetingappproblem.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    public String getGreeting() {
        return "Hello World";
    }

    public String getGreetingWithName(String firstName, String lastName) {
            return firstName+" " +lastName;
    }

}
