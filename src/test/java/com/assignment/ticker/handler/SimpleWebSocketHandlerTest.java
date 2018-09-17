package com.assignment.ticker.handler;

import com.assignment.ticker.model.LatestPrice;
import com.sun.xml.internal.ws.client.ClientTransportException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import java.time.ZonedDateTime;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@RunWith(SpringJUnit4ClassRunner.class)
public class SimpleWebSocketHandlerTest {
    private SimpleWebSocketHandler simpleWebSocketHandler;

    @Before
    public void setUp() {
        simpleWebSocketHandler = new SimpleWebSocketHandler();
    }

    @Mock
    private WebSocketSession session;

    @Mock
    private WebSocketMessage message;


    @Test
    public void afterConnectionEstablished() throws Exception {
        doNothing().when(session).sendMessage(any(TextMessage.class));
        simpleWebSocketHandler.afterConnectionEstablished(session);
        verify(session, times(1)).sendMessage(any(TextMessage.class));
    }

    @Test
    public void handleMessage() throws Exception {
        String priceString = "5606.62000000";
        when(message.getPayload()).thenReturn("{  \"price\": \"5606.62000000\",   \"time\": \"" + ZonedDateTime.now() + "\",}");
        simpleWebSocketHandler.handleMessage(session, message);
        assertThat(LatestPrice.getLatestPrice(), is(Float.parseFloat(priceString)));
    }

    @Test(expected = ClientTransportException.class)
    public void handleTransportError() throws Exception {
        simpleWebSocketHandler.handleTransportError(session, new Throwable());
    }

    @Test
    public void afterConnectionClosed() throws Exception {
        simpleWebSocketHandler.afterConnectionClosed(session, new CloseStatus(1111));
    }

}