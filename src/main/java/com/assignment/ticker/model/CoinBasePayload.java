package com.assignment.ticker.model;


public class CoinBasePayload {
    private String type;
    private String[] product_ids;
    private String[] channels;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String[] getProduct_ids() {
        return product_ids;
    }

    public void setProduct_ids(String[] product_ids) {
        this.product_ids = product_ids;
    }

    public String[] getChannels() {
        return channels;
    }

    public void setChannels(String[] channels) {
        this.channels = channels;
    }


    public static String getBTCEURTicker() {
        return "{\n" +
                "    \"type\": \"subscribe\",\n" +
                "    \"channels\": [{ \"name\": \"ticker\", \"product_ids\": [\"BTC-EUR\"] }]\n" +
                "}";
    }
}

