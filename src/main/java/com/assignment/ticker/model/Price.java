package com.assignment.ticker.model;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Table(name = "btc_price_in_eur")
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true, nullable = false)
    private int id;

    @Column(name = "CreatedAt", unique = true)
    private ZonedDateTime createdAt;

    @Column(name = "Price")
    private Float price;

    @PrePersist
    protected void onCreate() {
        createdAt = ZonedDateTime.now();
    }

    public Price(Float price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }
}

