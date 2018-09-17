package com.assignment.ticker.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Price {

    @Id
    private ObjectId _id;
    private Float price;
    private int timestamp;

    public Price(Float price) {
        this._id = ObjectId.get();
        this.price = price;
        this.timestamp = this._id.getTimestamp();
    }

    public String get_id() {
        return _id.toHexString();
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }
}

