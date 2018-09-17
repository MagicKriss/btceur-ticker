package com.assignment.ticker.Model;

import javafx.util.Pair;

import java.time.ZonedDateTime;


public class LatestPrice {
    private static Pair<ZonedDateTime, Float> btc_eur;

    public static Float getLatestPrice() {
        if (btc_eur != null)
            return btc_eur.getValue();
        else return null;
    }

    public static void setBtcEur(Float price, ZonedDateTime time) {
        if (btc_eur == null || btc_eur.getKey().isBefore(time)) {
            btc_eur = new Pair<>(time, price);
        }
    }
}