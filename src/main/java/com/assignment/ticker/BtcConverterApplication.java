package com.assignment.ticker;

import com.assignment.ticker.handler.SimpleWebSocketHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.socket.client.WebSocketConnectionManager;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;

@SpringBootApplication
@EnableScheduling
public class BtcConverterApplication {

    private static final String COINBASEPRO_WS_URI = "wss://ws-feed.pro.coinbase.com";

    public static void main(String[] args) {
        SpringApplication.run(BtcConverterApplication.class, args);
    }

    @Bean
    public WebSocketConnectionManager wsConnectionManager() {

        WebSocketConnectionManager connectionManager = new WebSocketConnectionManager(
                new StandardWebSocketClient(),
                new SimpleWebSocketHandler(),
                COINBASEPRO_WS_URI);
        connectionManager.setAutoStartup(true);

        return connectionManager;
    }

}
