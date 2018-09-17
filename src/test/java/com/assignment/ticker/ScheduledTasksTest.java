package com.assignment.ticker;

import com.assignment.ticker.model.LatestPrice;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.ZonedDateTime;

@RunWith(SpringJUnit4ClassRunner.class)
public class ScheduledTasksTest {
    private ScheduledTasks scheduledTasks;

    @Before
    public void setUp() {
        scheduledTasks = new ScheduledTasks();
    }

    @Test
    public void saveLatestPrice() throws Exception {
        LatestPrice.setBtcEur(Float.parseFloat("123.084"), ZonedDateTime.now());
        scheduledTasks.saveLatestPrice();
    }

}