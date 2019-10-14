package com.example.demo.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {
    @RequestMapping("/hi")
    public String hi(ModelMap map){
        map.addAttribute("host", "localhost");

        return "index";
    }
}
