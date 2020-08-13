package com.example.spring.boot.tacos.integration.handler;

import com.example.spring.boot.tacos.integration.model.Order;
import com.example.spring.boot.tacos.integration.properties.ApiProperties;
import org.springframework.integration.handler.GenericHandler;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component
public class OrderSubmitMessageHandler
        implements GenericHandler<Order> {
    private RestTemplate rest;
    private ApiProperties apiProps;
    public OrderSubmitMessageHandler(
            ApiProperties apiProps, RestTemplate rest) {
        this.apiProps = apiProps;
        this.rest = rest;
    }

    @Override
    public Object handle(Order order, MessageHeaders messageHeaders) {
        rest.postForObject(apiProps.getUrl(), order, String.class);
        return null;
    }
}
