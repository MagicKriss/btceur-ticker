package com.assignment.ticker.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.ZonedDateTime;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.hamcrest.core.IsNull.nullValue;

@RunWith(SpringJUnit4ClassRunner.class)
public class LatestPriceTest {


    @Test
    public void setBtcEur() throws Exception {
        Float price = Float.parseFloat("123.004");
        LatestPrice.setBtcEur(price, ZonedDateTime.now());
        assertThat(LatestPrice.getLatestPrice(), is(price));
        LatestPrice.setBtcEur(Float.parseFloat("2345.414"), ZonedDateTime.now().minusHours(2));
        assertThat(LatestPrice.getLatestPrice(), is(price));
    }

}