package org.example.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
public class HelloController {
    @GetMapping("hello")
    public String hello() {

        return "Hello World";
    }

}
