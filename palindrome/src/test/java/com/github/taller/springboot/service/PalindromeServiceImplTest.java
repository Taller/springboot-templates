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
public class PalindromeServiceImplTest {

    private PalindromeService service;

    @DataProvider
    public static Object[][] wordSet() {
        return new Object[][]{
                {"word", Boolean.FALSE},
                {"a", Boolean.TRUE},
                {"abba", Boolean.TRUE},
                {"Abba", Boolean.TRUE},
                {"Mikle", Boolean.FALSE},
                {"Eve", Boolean.TRUE}
        };
    }

    @DataProvider
    public static Object[][] phraseSet() {
        return new Object[][]{
                {"Sum summus mus", Boolean.TRUE},
                {"Аргентина манит негра", Boolean.TRUE},
                {"Абра кадабра", Boolean.FALSE}
        };
    }


    @Before
    public void setUp() {
        service = new PalindromeServiceImpl();
    }

    @Test
    @UseDataProvider("wordSet")
    public void testCheckWord(String word, boolean isPalindrome) throws Exception {

        assertThat(service.checkWord(word), is(isPalindrome));
    }

    @Test
    @UseDataProvider("phraseSet")
    public void testCheckPhrase(String phrase, boolean isPalindrome) throws Exception {

        assertThat(service.checkPhrase(phrase), is(isPalindrome));

    }
}