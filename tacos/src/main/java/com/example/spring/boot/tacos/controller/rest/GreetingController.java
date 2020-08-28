package com.example.spring.boot.tacos.controller.rest;

import com.example.spring.boot.tacos.controller.properties.GreetingProps;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    private final GreetingProps props;
    public GreetingController(GreetingProps props) {
        this.props = props;
    }
    @GetMapping("/hello")
    public String message() {
        return props.getMessage();
    }
}
