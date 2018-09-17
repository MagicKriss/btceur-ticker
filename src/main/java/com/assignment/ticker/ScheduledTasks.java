package com.assignment.ticker;

import com.assignment.ticker.Model.Price;
import org.slf4j.Logger;
import com.assignment.ticker.Model.LatestPrice;
import com.assignment.ticker.repository.PriceRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class ScheduledTasks {
    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);
    @Autowired
    private PriceRepository repository;
    @Autowired
    private Environment env;

    @Scheduled(fixedRateString = "${scheduling.time}")
    public void saveLatestPrice() {
        try {
            log.info("Saving latest price to database");
            if (LatestPrice.getLatestPrice() != null) repository.save(new Price(LatestPrice.getLatestPrice()));
        } catch (Exception ex) {
            log.error("Something went wrong while saving data to the database ", ex);
        }
    }
}