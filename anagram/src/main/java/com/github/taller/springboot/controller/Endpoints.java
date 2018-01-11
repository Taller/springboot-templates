package com.github.taller.springboot.controller;


import com.github.taller.springboot.service.AnagramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/anagram")
public class Endpoints {

    @Autowired
    AnagramService service;

    @GetMapping(value = "check-words", params = {"word1", "word2"})
    public String checkWords(@RequestParam(name = "word1", required = false) String word1,
                             @RequestParam(name = "word2", required = false) String word2) {

        boolean result = (word1 != null && word2 != null && service.checkWords(word1, word2));

        return "{\"result\":\"" + result + "\"}";
    }

}
