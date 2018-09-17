package com.assignment.ticker.handler;

import com.assignment.ticker.model.CoinBasePayload;
import com.assignment.ticker.model.LatestPrice;
import com.sun.xml.internal.ws.client.ClientTransportException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.*;

import java.io.IOException;
import java.time.ZonedDateTime;


public class SimpleWebSocketHandler implements WebSocketHandler {

    private static final String CURRENCY_PAIR = "BTC-EUR";
    private static final Logger log = LoggerFactory.getLogger(SimpleWebSocketHandler.class);


    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        log.info("Connection established!");
        subscribeToTicker(session, CURRENCY_PAIR);
    }


    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        log.debug("New message recieved");
        JSONObject jsonObj = new JSONObject(message.getPayload().toString());
        if (jsonObj.has("price")) {
            Float parsedPrice = Float.parseFloat((String) jsonObj.get("price"));
            ZonedDateTime parsedDateTime;
            if (jsonObj.has("time")) {
                parsedDateTime = ZonedDateTime.parse((String) jsonObj.get("time"));
            } else {
                parsedDateTime = ZonedDateTime.now();
            }
            log.debug("Setting new last price");
            LatestPrice.setBtcEur(parsedPrice, parsedDateTime);
        }
    }


    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        log.error("Transport error ", exception);
        throw new ClientTransportException(exception);
    }


    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        log.info("Connection is closed with reason " + closeStatus.getReason());
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }


    private void subscribeToTicker(WebSocketSession session, String currencyPairSymbol) throws IOException {
        log.info("Sending subscription message");
        TextMessage tm = new TextMessage(CoinBasePayload.getBTCEURTicker());
        session.sendMessage(tm);

    }


}
