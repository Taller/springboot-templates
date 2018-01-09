package com.github.taller.springboot.controller;


import com.github.taller.springboot.service.PalindromeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/palindrome")
public class Endpoints {

    @Autowired
    PalindromeService service;

    @GetMapping(value = "check-word", params = "word")
    public String checkWord(@RequestParam(name = "word", required = false) String word) {

        boolean result = (word != null && service.checkWord(word));

        return "{\"result\":\"" + result + "\"}";
    }


    @GetMapping(value = "check-phrase")
    public String checkPhrase(@RequestParam(name = "phrase", required = false) String phrase) {

        boolean result = (phrase != null && service.checkPhrase(phrase));

        return "{\"result\":\"" + result + "\"}";
    }
}
