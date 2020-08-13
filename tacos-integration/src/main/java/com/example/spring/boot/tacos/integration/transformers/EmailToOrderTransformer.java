package com.example.spring.boot.tacos.integration.transformers;

import com.example.spring.boot.tacos.integration.model.Order;
import org.springframework.integration.mail.transformer.AbstractMailMessageTransformer;
import org.springframework.integration.support.AbstractIntegrationMessageBuilder;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Component;

import javax.mail.Message;

@Component
public class EmailToOrderTransformer
        extends AbstractMailMessageTransformer<Order> {
    @Override
    protected AbstractIntegrationMessageBuilder<Order>
    doTransform(javax.mail.Message mailMessage) throws Exception {
        Order tacoOrder = processPayload(mailMessage);
        return MessageBuilder.withPayload(tacoOrder);
    }

    private Order processPayload(Message mailMessage) {
        return null;
    }
}
