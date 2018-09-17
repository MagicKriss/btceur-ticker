package com.assignment.ticker;

import com.assignment.ticker.handler.SimpleWebSocketHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.socket.client.WebSocketConnectionManager;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;

@SpringBootApplication
@EnableScheduling
public class BTCEURTickerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BTCEURTickerApplication.class, args);
    }

    @Bean
    public WebSocketConnectionManager wsConnectionManager(@Value("${coinbase.uri}") String coinbaseUri) {

        WebSocketConnectionManager connectionManager = new WebSocketConnectionManager(
                new StandardWebSocketClient(),
                new SimpleWebSocketHandler(),
                coinbaseUri);
        connectionManager.setAutoStartup(true);

        return connectionManager;
    }

}
