package com.bridgelabz.greetingappproblem.controller;
import com.bridgelabz.greetingappproblem.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greetingsController")
public class GreetingsController {

    @Autowired
    GreetingService greetingService;
    @GetMapping("/greet")
    public String getGreeting(){
        return greetingService.getGreeting();
    }

}
