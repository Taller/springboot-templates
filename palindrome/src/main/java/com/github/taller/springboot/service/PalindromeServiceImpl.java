package com.github.taller.springboot.service;

import org.springframework.stereotype.Service;

@Service
public class PalindromeServiceImpl implements PalindromeService {

    @Override
    public boolean checkWord(String word) {

        String upperWord = word.toUpperCase();

        return isPalindrome(upperWord);
    }

    @Override
    public boolean checkPhrase(String phrase) {

        String upperPhrase = phrase.replace(" ", "").toUpperCase();

        return isPalindrome(upperPhrase);
    }

    private boolean isPalindrome(String str) {
        return str.equals(new StringBuilder(str).reverse().toString());
    }
}
