package com.example.Restfullsoap;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
    @GetMapping("/help")
    public String help(){
        return "This is a toy project, it's built to prove the idea that I understood the concepts " +
                "of multiple technologies, you can send your try to request the link:" +
                " http://localhost:8080/greeting?name=Hadi\n Additionally, you can writing the following command inside the project's directory:" +
                "curl --header \"content-type: text/xml\" -d @request.xml http://localhost:8080/ws";
    }
}