package com.example.Restfullsoap;

import org.springframework.web.bind.annotation.*;

@RestController
public class RequestController {
    @GetMapping("/test")
    public String test(){
        return "Working";
    }

    @PostMapping("/users")
    void newUser(@RequestBody User newUser) {
        DataWriter writer = new DataWriter();
        writer.writeUser(newUser);
    }

    @GetMapping("/users/{id}")
    User one(@PathVariable int id) {
        DataReader reader = new DataReader();
        return reader.readUser(id);
    }
}
