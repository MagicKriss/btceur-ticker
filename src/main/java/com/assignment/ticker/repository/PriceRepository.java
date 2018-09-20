package com.assignment.ticker.repository;


import com.assignment.ticker.model.Price;
import org.springframework.data.repository.CrudRepository;

public interface PriceRepository extends CrudRepository<Price, String> {
}
