package com.bridgelabz.greetingappproblem.controller;
import com.bridgelabz.greetingappproblem.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greetingsController")
public class GreetingsController {

    @Autowired
    GreetingService greetingService;

    @GetMapping("/greet")
    public String getGreeting(){
        return greetingService.getGreeting();
    }

    @GetMapping(value = {"/","/greetingmessage","homemessage"})
    public String helloMessage(@RequestParam(value ="firstName", defaultValue ="HelloWorld!") String firstName,@RequestParam (value ="lastName", defaultValue ="HelloWorld!") String lastName) {
        return greetingService.getGreetingWithName(firstName,lastName);
    }


}
