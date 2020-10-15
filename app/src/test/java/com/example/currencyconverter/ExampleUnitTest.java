package com.example.currencyconverter;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void convertUsdToPLN() {
        MainActivity mainActivity = new MainActivity();
        GetTheCurrentExchangeRate getTheCurrentExchangeRate = new GetTheCurrentExchangeRate();

        Double USD = 100.00;
        Double result = USD * getTheCurrentExchangeRate.get_USD();

        Assert.assertEquals(mainActivity.convert(100.00, getTheCurrentExchangeRate.get_USD()), result, 0.01);
    }
}