package com.alexsandrov.spring_boot_course.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExternalController {

    @GetMapping("/")
    public String showUsers() {
        return "index";
    }
}
