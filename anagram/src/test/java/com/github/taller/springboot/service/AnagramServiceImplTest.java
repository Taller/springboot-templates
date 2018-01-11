package com.github.taller.springboot.service;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


@RunWith(DataProviderRunner.class)
public class AnagramServiceImplTest {

    private AnagramService service;

    @DataProvider
    public static Object[][] wordSet() {
        return new Object[][]{
                {"rail safety", "fairy tales", Boolean.TRUE},
                {"roast beef", "eat for BSE", Boolean.TRUE},
                {"William Shakespeare", "I am a weakish speller", Boolean.TRUE},
                {"Madam Curie", "Radium came", Boolean.TRUE},
                {"word", "Mikle", Boolean.FALSE},
                {"word", "Eve", Boolean.FALSE}
        };
    }

    @Before
    public void setUp() {
        service = new AnagramServiceImpl();
    }

    @Test
    @UseDataProvider("wordSet")
    public void testCheckWord(String word1, String word2, boolean isPalindrome) throws Exception {

        assertThat(service.checkWords(word1, word2 ), is(isPalindrome));
    }


}