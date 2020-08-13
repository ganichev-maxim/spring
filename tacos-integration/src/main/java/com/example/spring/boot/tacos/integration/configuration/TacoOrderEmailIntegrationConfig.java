package com.example.spring.boot.tacos.integration.configuration;

import com.example.spring.boot.tacos.integration.handler.OrderSubmitMessageHandler;
import com.example.spring.boot.tacos.integration.properties.EmailProperties;
import com.example.spring.boot.tacos.integration.transformers.EmailToOrderTransformer;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.Pollers;
import org.springframework.integration.mail.dsl.Mail;
import org.springframework.web.client.RestTemplate;

@Configuration
public class TacoOrderEmailIntegrationConfig {

    @Bean
    public IntegrationFlow tacoOrderEmailFlow(
            EmailProperties emailProps,
            EmailToOrderTransformer emailToOrderTransformer,
            OrderSubmitMessageHandler orderSubmitHandler) {
        return IntegrationFlows
                .from(Mail.imapInboundAdapter(emailProps.getImapUrl()),
                        e -> e.poller(
                                Pollers.fixedDelay(emailProps.getPollRate())))
                .transform(emailToOrderTransformer)
                .handle(orderSubmitHandler)
                .get();
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        // Do any additional configuration here
        return builder.build();
    }
}
