package com.github.taller.springboot.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class AnagramServiceImpl implements AnagramService {

    @Override
    public boolean checkWords(String word1, String word2) {

        char[] charUpper1 = word1.toUpperCase().replace(" ", "").toCharArray();
        Arrays.sort(charUpper1);

        char[] charUpper2 = word2.toUpperCase().replace(" ", "").toCharArray();
        Arrays.sort(charUpper2);

        return Arrays.equals(charUpper1, charUpper2);
    }
}
