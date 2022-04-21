package com.whatsapp.mensajeria.DemoWApp.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class TopicConfig {
    @Bean
    public NewTopic ejemploTopic(){
        return TopicBuilder.name("ejemploTopic")
                .build();
    }
}
