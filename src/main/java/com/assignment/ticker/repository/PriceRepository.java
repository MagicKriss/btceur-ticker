package com.assignment.ticker.repository;

import com.assignment.ticker.Model.Price;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PriceRepository extends MongoRepository<Price, String> {
}
