package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class FilmeController {
    @GetMapping("detail/{type}/{path}")
    public String toDetail(@PathVariable("type") String type,
                           @PathVariable("path") String path) {
        return "detail/" + type + "/" + path;
    }

    @GetMapping("/")
    public String toIndex() {
        return "index";
    }

    @GetMapping("/userLogin")
    public String toLoginPage() {
        return "login/login";
    }
}
