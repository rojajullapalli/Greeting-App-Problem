package com.bridgelabz.greetingappproblem.controller;
import com.bridgelabz.greetingappproblem.dto.GreetingsDto;
import com.bridgelabz.greetingappproblem.model.Greetings;
import com.bridgelabz.greetingappproblem.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping(value = "/addGreeting")
    public Greetings addGreetings(@RequestBody GreetingsDto greetingsDto){
        return greetingService.addGreeting(greetingsDto);
    }

    @GetMapping(value="/get-By-Id")
    public Greetings getGreetingsById(@RequestParam int id){
        return  greetingService.getGreetingById(id);
    }

    @GetMapping(value="/getAllMessages")
    public List<Greetings> getAllGreetings(){
        return  greetingService.greetings();
    }

    @PutMapping(value = "/updateMessage/{id}")
    public Greetings updateGreeting(
            @PathVariable int id,
            @RequestBody GreetingsDto greetingsDTO) {
        return greetingService.updateGreeting(id, greetingsDTO);
    }

}
