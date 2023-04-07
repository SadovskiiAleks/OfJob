package com.example.goodJobAleks.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/faq")
public class FaqController {
    @GetMapping
    public String userPage(Model model){

        return "faq-main";
    }


}

